package cn.liboshuai.jrisk.module.risk.enums.cond;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiskCondType {

    RANGE("range"),
    RECENT("recent");

    private final String value;
}
