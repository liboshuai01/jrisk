package cn.liboshuai.jrisk.module.risk.enums.rule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiskRuleLevel {

    one(1),
    two(2),
    three(3),
    four(4);


    private final int value;
}
