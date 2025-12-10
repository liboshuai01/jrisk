package cn.liboshuai.jrisk.module.risk.dal.dataobject.rule;

import cn.liboshuai.jrisk.framework.mybatis.core.dataobject.BaseDO;
import cn.liboshuai.jrisk.framework.tenant.core.aop.TenantIgnore;
import cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleChannel;
import cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleLevel;
import cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleStatus;
import cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleTarget;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 风控规则 DO
 *
 * @author 李博帅
 * @since 2025-12-10
 */
@TableName(value = "risk_rule", autoResultMap = true)
@KeySequence("risk_rule_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TenantIgnore
public class RuleDO extends BaseDO implements Serializable {

    /**
     * 规则编号，自增
     */
    private Long id;

    /**
     * 规则编码
     */
    private Long ruleId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 预警级别
     * 枚举 {@link RiskRuleLevel}
     */
    private Integer riskLevel;

    /**
     * 预警模板
     */
    private String riskTemplate;

    /**
     * 渠道
     * 枚举 {@link RiskRuleChannel}
     */
    private String channel;

    /**
     * 目标
     * 枚举 {@link RiskRuleTarget}
     */
    private String target;

    /**
     * 状态
     * 枚举 {@link RiskRuleStatus}
     */
    private Integer status;

}
