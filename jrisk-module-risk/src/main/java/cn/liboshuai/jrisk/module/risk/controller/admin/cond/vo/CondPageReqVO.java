package cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.liboshuai.jrisk.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.liboshuai.jrisk.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 风控条件分页 Request VO")
@Data
public class CondPageReqVO extends PageParam {

    @Schema(description = "条件编号", example = "19606")
    private Long condId;

    @Schema(description = "条件类型", example = "recent")
    private String condType;

    @Schema(description = "规则编号", example = "18272")
    private Long ruleId;

}