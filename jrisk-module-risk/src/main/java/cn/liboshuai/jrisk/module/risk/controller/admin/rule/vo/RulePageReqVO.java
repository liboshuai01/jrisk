package cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo;

import cn.liboshuai.jrisk.framework.common.pojo.PageParam;
import cn.liboshuai.jrisk.module.risk.enums.rule.RiskRuleStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.liboshuai.jrisk.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 风控规则 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RulePageReqVO extends PageParam {

    @Schema(description = "规则编码", example = "30883")
    private Long ruleId;

    @Schema(description = "规则名称", example = "高频抽奖")
    private String ruleName;

    @Schema(description = "规则状态，参见 RiskRuleStatus 枚举", example = "0")
    private Integer status;

}
