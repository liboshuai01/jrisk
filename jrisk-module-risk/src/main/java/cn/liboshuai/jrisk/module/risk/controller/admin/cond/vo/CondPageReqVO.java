package cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo;

import cn.liboshuai.jrisk.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.liboshuai.jrisk.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 风控条件分页 Request VO")
@Data
public class CondPageReqVO extends PageParam {

    @Schema(description = "条件编号", example = "6962")
    private Long condId;

    @Schema(description = "条件类型", example = "rencent")
    private String condType;

    @Schema(description = "跨历史时间点")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] timeline;

    @Schema(description = "规则编号", example = "210")
    private Long ruleId;

}