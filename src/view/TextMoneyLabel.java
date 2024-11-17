package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextMoneyLabel {

    public TextMoneyLabel(JPanel bottomLabelPanel, String text, Double money) {
        JPanel panel = new JPanel();
        bottomLabelPanel.add(panel);
        panel.setOpaque(false);
        JLabel label = new JLabel(text);
        panel.add(label);
        JLabel labelMoney = new JLabel("R$ " + money.toString().replace(".", ","));
        panel.add(labelMoney);
    }
}
