package org.miu.lab5.prob1.rulesets;

import org.miu.lab5.prob1.gui.BookWindow;
import org.miu.lab5.prob1.gui.CDWindow;

import java.awt.Component;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Price must be a floating point number with two decimal places
 * 3. Price must be a number greater than 0.49.
 */

public class CDRuleSet implements RuleSet {

    @Override
    public void applyRules(Component component) throws RuleException {
        CDWindow cdWindow = (CDWindow) component;
        nonemptyRules(cdWindow);
        priceRule(cdWindow);
    }


    private void nonemptyRules(CDWindow cdWindow) throws RuleException {

        if (cdWindow.getArtistValue().trim().isEmpty() || cdWindow.getPriceValue().trim().isEmpty() || cdWindow.getTitleValue().trim().isEmpty())
            throw new RuleException("All fields must be nonempty");

    }


    private void priceRule(CDWindow cdWindow) throws RuleException {

        String price = cdWindow.getPriceValue().trim();

        try {
            Double.parseDouble(price);
        } catch (NumberFormatException exception) {
            throw new RuleException("Price must be a floating point number.");
        }

        if (price.split("\\.")[1].length() != 2) {
            throw new RuleException("Price must have exactly two digits after the decimal point.");

        }
        if (Double.parseDouble(price) <= 0.49) throw new RuleException("Price must have value bigger than 0.49.");

    }

}
