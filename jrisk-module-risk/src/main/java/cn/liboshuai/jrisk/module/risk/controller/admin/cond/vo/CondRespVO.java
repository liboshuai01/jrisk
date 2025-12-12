package cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import cn.liboshuai.jrisk.framework.excel.core.annotations.DictFormat;
import cn.liboshuai.jrisk.framework.excel.core.convert.DictConvert;
import cn.liboshuai.jrisk.module.risk.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 风控条件 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CondRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "条件编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "6962")
    @ExcelProperty("条件编号")
    private Long condId;

    @Schema(description = "条件类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "rencent")
    @ExcelProperty(value = "条件类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COND_TYPE)
    private String condType;

    @Schema(description = "窗口值", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("窗口值")
    private Long windowValue;

    @Schema(description = "窗口单位", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("窗口单位")
    private String windowUnit;

    @Schema(description = "阈值", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("阈值")
    private BigDecimal threshold;

    @Schema(description = "跨历史时间点", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("跨历史时间点")
    private LocalDateTime timeline;

    @Schema(description = "规则编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "210")
    @ExcelProperty("规则编号")
    private Long ruleId;

}
