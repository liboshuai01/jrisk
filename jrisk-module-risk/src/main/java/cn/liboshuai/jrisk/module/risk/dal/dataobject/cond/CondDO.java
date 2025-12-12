package cn.liboshuai.jrisk.module.risk.dal.dataobject.cond;

import com.sun.xml.bind.v2.TODO;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.liboshuai.jrisk.framework.mybatis.core.dataobject.BaseDO;

/**
 * 风控条件 DO
 *
 * @author 李博帅
 */
@TableName("risk_cond")
@KeySequence("risk_cond_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CondDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 条件编号
     */
    private Long condId;
    /**
     * 条件类型
     *
     * 枚举 {@link TODO risk_cond.type 对应的类}
     */
    private String condType;
    /**
     * 窗口值
     */
    private Long windowValue;
    /**
     * 窗口单位
     */
    private String windowUnit;
    /**
     * 阈值
     */
    private BigDecimal threshold;
    /**
     * 跨历史时间点
     */
    private LocalDateTime timeline;
    /**
     * 规则编号
     */
    private Long ruleId;

}