package org.miu.lab5.prob1.rulesets;

import java.awt.Component;

public interface RuleSet {

    int name = 0;

    public void applyRules(Component component) throws RuleException;

}
