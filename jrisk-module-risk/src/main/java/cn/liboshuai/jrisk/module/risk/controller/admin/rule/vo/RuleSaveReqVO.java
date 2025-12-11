package cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 风控规则新增/修改 Request VO")
@Data
public class RuleSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "12827")
    private Long id;

    @Schema(description = "规则编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18652")
    @NotNull(message = "规则编号不能为空")
    private Long ruleId;

    @Schema(description = "规则名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "规则名称不能为空")
    private String ruleName;

    @Schema(description = "规则描述")
    private String ruleDesc;

    @Schema(description = "预警模板", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "预警模板不能为空")
    private String template;

    @Schema(description = "预警级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @NotNull(message = "预警级别不能为空")
    private Integer level;

    @Schema(description = "渠道", requiredMode = Schema.RequiredMode.REQUIRED, example = "game")
    @NotEmpty(message = "渠道不能为空")
    private String channel;

    @Schema(description = "目标", requiredMode = Schema.RequiredMode.REQUIRED, example = "user")
    @NotEmpty(message = "目标不能为空")
    private String target;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}