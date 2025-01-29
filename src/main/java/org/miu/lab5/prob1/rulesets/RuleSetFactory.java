package org.miu.lab5.prob1.rulesets;

import org.miu.lab5.prob1.gui.BookWindow;
import org.miu.lab5.prob1.gui.CDWindow;

import java.awt.Component;
import java.util.HashMap;


final public class RuleSetFactory {
    static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();

    static {
        map.put(CDWindow.class, new CDRuleSet());
        map.put(BookWindow.class, new BookRuleSet());
    }


    public static RuleSet getRuleSet(Component component) {

        Class<? extends Component> componentClass = component.getClass();

        if (!map.containsKey(componentClass)) throw new IllegalArgumentException("No RuleSet found for this Component");

        return map.get(componentClass);
    }


}
