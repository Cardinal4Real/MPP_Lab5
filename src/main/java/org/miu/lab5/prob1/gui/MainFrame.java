package org.miu.lab5.prob1.gui;

import org.miu.lab5.prob1.rulesets.BookRuleSet;
import org.miu.lab5.prob1.rulesets.CDRuleSet;
import org.miu.lab5.prob1.rulesets.RuleSetFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    CDWindow cdWin = new CDWindow();
    BookWindow bookWin = new BookWindow();

    public MainFrame() {
        JPanel mainPanel = new JPanel();
        JButton cdButton = new JButton("Go to CD Window");
        cdButton.addActionListener(new CDWindowListener());
        JButton bookButton = new JButton("Go to Book Window");
        bookButton.addActionListener(new BookWindowListener());
        mainPanel.add(cdButton);
        mainPanel.add(bookButton);
        getContentPane().add(mainPanel);
        pack();
    }

    class CDWindowListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            cdWin.setVisible(true);
            bookWin.setVisible(false);
        }
    }

    class BookWindowListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            cdWin.setVisible(false);
            bookWin.setVisible(true);
        }
    }

    public static void main(String[] args) {
        (new MainFrame()).setVisible(true);
    }

}
