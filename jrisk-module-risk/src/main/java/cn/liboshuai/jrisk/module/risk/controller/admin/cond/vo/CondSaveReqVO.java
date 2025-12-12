package cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 风控条件新增/修改 Request VO")
@Data
public class CondSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13024")
    private Long id;

    @Schema(description = "条件编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "6962")
    @NotNull(message = "条件编号不能为空")
    private Long condId;

    @Schema(description = "条件类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "rencent")
    @NotEmpty(message = "条件类型不能为空")
    private String condType;

    @Schema(description = "窗口值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "窗口值不能为空")
    private Long windowValue;

    @Schema(description = "窗口单位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "窗口单位不能为空")
    private String windowUnit;

    @Schema(description = "阈值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "阈值不能为空")
    private BigDecimal threshold;

    @Schema(description = "跨历史时间点", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "跨历史时间点不能为空")
    private LocalDateTime timeline;

    @Schema(description = "规则编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "210")
    @NotNull(message = "规则编号不能为空")
    private Long ruleId;

}