package cn.liboshuai.jrisk.module.risk.service.rule;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageReqVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RuleSaveReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import cn.liboshuai.jrisk.module.risk.dal.mysql.RuleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService{

    private final RuleMapper ruleMapper;

    @Override
    public PageResult<RuleDO> getRulePage(RulePageReqVO pageReqVO) {
        return ruleMapper.selectPage(pageReqVO);
    }

    @Override
    public RuleDO getRule(Long id) {
        return ruleMapper.selectById(id);
    }

    @Override
    public Long createRule(RuleSaveReqVO createReqVO) {
        return (long) ruleMapper.insert(BeanUtils.toBean(createReqVO, RuleDO.class));
    }

    @Override
    public void updateRule(RuleSaveReqVO updateReqVO) {
        ruleMapper.updateById(BeanUtils.toBean(updateReqVO, RuleDO.class));
    }

    @Override
    public void deleteRule(Long id) {
        ruleMapper.deleteById(id);
    }

    @Override
    public void updateRuleStatus(Long id, Integer status) {

    }
}
