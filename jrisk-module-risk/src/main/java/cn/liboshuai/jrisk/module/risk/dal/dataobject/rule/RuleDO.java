package cn.liboshuai.jrisk.module.risk.dal.dataobject.rule;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.liboshuai.jrisk.framework.mybatis.core.dataobject.BaseDO;

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
     * 枚举 {@link TODO risk_rule.level 对应的类}
     */
    private Integer level;
    /**
     * 渠道
     *
     * 枚举 {@link TODO risk_rule.channel 对应的类}
     */
    private String channel;
    /**
     * 目标
     *
     * 枚举 {@link TODO risk_rule.target 对应的类}
     */
    private String target;
    /**
     * 状态
     *
     * 枚举 {@link TODO risk_rule.status 对应的类}
     */
    private Integer status;


}