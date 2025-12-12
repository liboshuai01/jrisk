package cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo;

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

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "5004")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "规则编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11571")
    @ExcelProperty("规则编号")
    private Long ruleId;

    @Schema(description = "规则名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("规则名称")
    private String ruleName;

    @Schema(description = "预警级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "预警级别", converter = DictConvert.class)
    @DictFormat("risk_rule.level") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer level;

    @Schema(description = "渠道", requiredMode = Schema.RequiredMode.REQUIRED, example = "game")
    @ExcelProperty(value = "渠道", converter = DictConvert.class)
    @DictFormat("risk_rule.channel") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String channel;

    @Schema(description = "目标", requiredMode = Schema.RequiredMode.REQUIRED, example = "user")
    @ExcelProperty(value = "目标", converter = DictConvert.class)
    @DictFormat("risk_rule.target") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String target;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("risk_rule.status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新者")
    @ExcelProperty("更新者")
    private String updater;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}