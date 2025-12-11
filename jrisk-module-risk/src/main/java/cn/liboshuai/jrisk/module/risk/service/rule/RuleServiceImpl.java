package cn.liboshuai.jrisk.module.risk.service.rule;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageReqVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RuleSaveReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import cn.liboshuai.jrisk.module.risk.dal.mysql.rule.RuleMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

import static cn.liboshuai.jrisk.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.liboshuai.jrisk.module.risk.enums.ErrorCodeConstants.RULE_NOT_EXISTS;

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

    @Override
    public Long createRule(RuleSaveReqVO createReqVO) {
        // 插入
        RuleDO rule = BeanUtils.toBean(createReqVO, RuleDO.class);
        ruleMapper.insert(rule);

        // 返回
        return rule.getId();
    }

    @Override
    public void updateRule(RuleSaveReqVO updateReqVO) {
        // 校验存在
        validateRuleExists(updateReqVO.getId());
        // 更新
        RuleDO updateObj = BeanUtils.toBean(updateReqVO, RuleDO.class);
        ruleMapper.updateById(updateObj);
    }

    @Override
    public void deleteRule(Long id) {
        // 校验存在
        validateRuleExists(id);
        // 删除
        ruleMapper.deleteById(id);
    }

    @Override
        public void deleteRuleListByIds(List<Long> ids) {
        // 删除
        ruleMapper.deleteByIds(ids);
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

}