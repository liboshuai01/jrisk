package cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo;

import cn.liboshuai.jrisk.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.liboshuai.jrisk.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 风控规则分页 Request VO")
@Data
public class RulePageReqVO extends PageParam {

    @Schema(description = "规则编号", example = "11571")
    private Long ruleId;

    @Schema(description = "规则名称", example = "张三")
    private String ruleName;

    @Schema(description = "预警级别", example = "2")
    private Integer level;

    @Schema(description = "渠道", example = "game")
    private String channel;

    @Schema(description = "目标", example = "user")
    private String target;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}