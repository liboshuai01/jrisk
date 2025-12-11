package cn.liboshuai.jrisk.module.risk.enums.rule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiskRuleChannel {

    GAME("game"),
    MALL("mall");

    private final String value;
}
