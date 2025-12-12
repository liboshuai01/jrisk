package cn.liboshuai.jrisk.module.risk.dal.dataobject.rule;

import cn.liboshuai.jrisk.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 风控规则 DO
 *
 * @author 李博帅
 */
@TableName("risk_rule")
@KeySequence("risk_rule_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 规则编号
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
     * 预警模板
     */
    private String template;
    /**
     * 预警级别
     *
     * 枚举 {@link cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleLevel 对应的类}
     */
    private Integer level;
    /**
     * 渠道
     *
     * 枚举 {@link cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleChannel 对应的类}
     */
    private String channel;
    /**
     * 目标
     *
     * 枚举 {@link cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleTarget 对应的类}
     */
    private String target;
    /**
     * 状态
     *
     * 枚举 {@link cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleStatus 对应的类}
     */
    private Integer status;


}
