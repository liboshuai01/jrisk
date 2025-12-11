package cn.liboshuai.jrisk.module.risk.enums.rule;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiskRuleStatus {

    ENABLED(0),
    DISABLED(1);

    private final int value;
}
