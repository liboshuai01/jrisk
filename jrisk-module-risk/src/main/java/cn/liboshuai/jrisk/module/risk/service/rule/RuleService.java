package cn.liboshuai.jrisk.module.risk.service.rule;

import java.util.*;
import javax.validation.*;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.*;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.cond.CondDO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import cn.liboshuai.jrisk.framework.common.pojo.PageResult;

/**
 * 风控规则 Service 接口
 *
 * @author 李博帅
 */
public interface RuleService {

    /**
     * 创建风控规则
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRule(@Valid RuleSaveReqVO createReqVO);

    /**
     * 更新风控规则
     *
     * @param updateReqVO 更新信息
     */
    void updateRule(@Valid RuleSaveReqVO updateReqVO);

    /**
     * 删除风控规则
     *
     * @param id 编号
     */
    void deleteRule(Long id);

    /**
    * 批量删除风控规则
    *
    * @param ids 编号
    */
    void deleteRuleListByIds(List<Long> ids);

    /**
     * 获得风控规则
     *
     * @param id 编号
     * @return 风控规则
     */
    RuleDO getRule(Long id);

    /**
     * 获得风控规则分页
     *
     * @param pageReqVO 分页查询
     * @return 风控规则分页
     */
    PageResult<RuleDO> getRulePage(RulePageReqVO pageReqVO);

    // ==================== 子表（风控条件） ====================

    /**
     * 获得风控条件列表
     *
     * @param ruleId 规则编号
     * @return 风控条件列表
     */
    List<CondDO> getCondListByRuleId(Long ruleId);

}