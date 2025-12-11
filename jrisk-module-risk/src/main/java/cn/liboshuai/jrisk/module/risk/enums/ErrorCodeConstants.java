package cn.liboshuai.jrisk.module.risk.enums;

import cn.liboshuai.jrisk.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 风控 模块 1-010-000-000 ==========
    ErrorCode COND_NOT_EXISTS = new ErrorCode(1_010_000_000, "风控条件不存在");
    ErrorCode RULE_NOT_EXISTS = new ErrorCode(1_010_000_001, "风控规则不存在");

}
