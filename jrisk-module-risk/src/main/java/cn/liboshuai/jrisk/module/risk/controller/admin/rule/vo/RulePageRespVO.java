package cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 风控规则 Response VO")
@Data
public class RulePageRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "31020")
    private Long id;

    @Schema(description = "规则编码", example = "30883")
    private Long ruleId;

    @Schema(description = "规则名称", example = "高频抽奖")
    private String ruleName;

    @Schema(description = "预警级别，参见 RiskRuleLevel 枚举", example = "0")
    private Integer riskLevel;

    @Schema(description = "规则状态，参见 RiskRuleStatus 枚举", example = "0")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式")
    private LocalDateTime createTime;

    @Schema(description = "创建者", example = "101")
    private String creator;

}
