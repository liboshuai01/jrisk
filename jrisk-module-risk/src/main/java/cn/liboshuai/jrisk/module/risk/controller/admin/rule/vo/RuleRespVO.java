package cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo;

import cn.liboshuai.jrisk.module.risk.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import cn.idev.excel.annotation.*;
import cn.liboshuai.jrisk.framework.excel.core.annotations.DictFormat;
import cn.liboshuai.jrisk.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 风控规则 Response VO")
@Data
@ExcelIgnoreUnannotated
public class RuleRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "12827")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "规则编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18652")
    @ExcelProperty("规则编号")
    private Long ruleId;

    @Schema(description = "规则名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("规则名称")
    private String ruleName;

    @Schema(description = "规则描述")
    @ExcelProperty("规则描述")
    private String ruleDesc;

    @Schema(description = "预警模板", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("预警模板")
    private String template;

    @Schema(description = "预警级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @ExcelProperty(value = "预警级别", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.RULE_LEVEL)
    private Integer level;

    @Schema(description = "渠道", requiredMode = Schema.RequiredMode.REQUIRED, example = "game")
    @ExcelProperty(value = "渠道", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.RULE_CHANNEL)
    private String channel;

    @Schema(description = "目标", requiredMode = Schema.RequiredMode.REQUIRED, example = "user")
    @ExcelProperty(value = "目标", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.RULE_TARGET)
    private String target;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.RULE_STATUS)
    private Integer status;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
