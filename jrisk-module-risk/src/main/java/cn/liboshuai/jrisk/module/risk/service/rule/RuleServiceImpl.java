package cn.liboshuai.jrisk.module.risk.service.rule;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.cond.CondDO;
import cn.liboshuai.jrisk.module.risk.dal.mysql.cond.CondMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.*;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;

import cn.liboshuai.jrisk.module.risk.dal.mysql.rule.RuleMapper;

import static cn.liboshuai.jrisk.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.liboshuai.jrisk.framework.common.util.collection.CollectionUtils.convertList;
import static cn.liboshuai.jrisk.framework.common.util.collection.CollectionUtils.diffList;
import static cn.liboshuai.jrisk.module.risk.enums.ErrorCodeConstants.*;

/**
 * 风控规则 Service 实现类
 *
 * @author 李博帅
 */
@Service
@Validated
public class RuleServiceImpl implements RuleService {

    @Resource
    private RuleMapper ruleMapper;
    @Resource
    private CondMapper condMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createRule(RuleSaveReqVO createReqVO) {
        // 插入
        RuleDO rule = BeanUtils.toBean(createReqVO, RuleDO.class);
        ruleMapper.insert(rule);


        // 插入子表
        createCondList(rule.getId(), createReqVO.getConds());
        // 返回
        return rule.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRule(RuleSaveReqVO updateReqVO) {
        // 校验存在
        validateRuleExists(updateReqVO.getId());
        // 更新
        RuleDO updateObj = BeanUtils.toBean(updateReqVO, RuleDO.class);
        ruleMapper.updateById(updateObj);

        // 更新子表
        updateCondList(updateReqVO.getId(), updateReqVO.getConds());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRule(Long id) {
        // 校验存在
        validateRuleExists(id);
        // 删除
        ruleMapper.deleteById(id);

        // 删除子表
        deleteCondByRuleId(id);
    }

    @Override
        @Transactional(rollbackFor = Exception.class)
    public void deleteRuleListByIds(List<Long> ids) {
        // 删除
        ruleMapper.deleteByIds(ids);
    
    // 删除子表
            deleteCondByRuleIds(ids);
    }


    private void validateRuleExists(Long id) {
        if (ruleMapper.selectById(id) == null) {
            throw exception(RULE_NOT_EXISTS);
        }
    }

    @Override
    public RuleDO getRule(Long id) {
        return ruleMapper.selectById(id);
    }

    @Override
    public PageResult<RuleDO> getRulePage(RulePageReqVO pageReqVO) {
        return ruleMapper.selectPage(pageReqVO);
    }

    // ==================== 子表（风控条件） ====================

    @Override
    public List<CondDO> getCondListByRuleId(Long ruleId) {
        return condMapper.selectListByRuleId(ruleId);
    }

    private void createCondList(Long ruleId, List<CondDO> list) {
        list.forEach(o -> o.setRuleId(ruleId).clean());
        condMapper.insertBatch(list);
    }

    private void updateCondList(Long ruleId, List<CondDO> list) {
	    list.forEach(o -> o.setRuleId(ruleId).clean());
	    List<CondDO> oldList = condMapper.selectListByRuleId(ruleId);
	    List<List<CondDO>> diffList = diffList(oldList, list, (oldVal, newVal) -> {
            boolean same = ObjectUtil.equal(oldVal.getId(), newVal.getId());
            if (same) {
                newVal.setId(oldVal.getId()).clean(); // 解决更新情况下：updateTime 不更新
            }
            return same;
	    });

	    // 第二步，批量添加、修改、删除
	    if (CollUtil.isNotEmpty(diffList.get(0))) {
	        condMapper.insertBatch(diffList.get(0));
	    }
	    if (CollUtil.isNotEmpty(diffList.get(1))) {
	        condMapper.updateBatch(diffList.get(1));
	    }
	    if (CollUtil.isNotEmpty(diffList.get(2))) {
	        condMapper.deleteByIds(convertList(diffList.get(2), CondDO::getId));
	    }
    }

    private void deleteCondByRuleId(Long ruleId) {
        condMapper.deleteByRuleId(ruleId);
    }

	private void deleteCondByRuleIds(List<Long> ruleIds) {
        condMapper.deleteByRuleIds(ruleIds);
	}

}