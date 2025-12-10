package cn.liboshuai.jrisk.module.risk.service.rule;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageReqVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RuleSaveReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;

public interface RuleService {
    PageResult<RuleDO> getRulePage(RulePageReqVO pageReqVO);

    RuleDO getRule(Long id);

    Long createRule(RuleSaveReqVO createReqVO);

    void updateRule(RuleSaveReqVO updateReqVO);

    void deleteRule(Long id);

    void updateRuleStatus(Long id, Integer status);
}
