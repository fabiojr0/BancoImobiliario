package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import controller.CtrlGame;
import controller.CtrlPlayers;
import model.Home;
import model.House;
import model.HousePanel;
import model.Player;

public class HouseDesc {
    HousePanel housePanel = null;

    public HouseDesc(JLayeredPane layeredPane, CtrlGame game) {
        game.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("houses")) {
                changeLabel(layeredPane, game);
            }
        });
    }

    private void changeLabel(JLayeredPane layeredPane, CtrlGame game) {
        Player player = game.players.get(CtrlPlayers.getOrder());
        
        if (player.getCurrentHouse() != null) {
            housePanel = player.getCurrentHouse();
        }

        // Verifique se housePanel não é null antes de acessar getHouse()
        if (housePanel != null) {
            House house = housePanel.getHouse();

            if (house instanceof Home) {

                Home home = (Home) house;

                JPanel houseDescPanel = new JPanel();
                houseDescPanel.setBounds(774, 52, 280, 300);
                houseDescPanel.setOpaque(true);
                houseDescPanel.setLayout(new BorderLayout());
                layeredPane.add(houseDescPanel);

                // Top label
                JPanel topLabelPanel = new JPanel();
                topLabelPanel.setOpaque(true);
                topLabelPanel.setPreferredSize(new Dimension(280, 30));
                topLabelPanel.setBackground(home.getColor());
                topLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

                JLabel topLabel = new JLabel("Descrição da Casa");
                topLabelPanel.add(topLabel);

                // Bottom label with BoxLayout for vertical arrangement
                JPanel bottomLabelPanel = new JPanel();
                bottomLabelPanel.setOpaque(true);
                bottomLabelPanel.setBackground(Color.LIGHT_GRAY);
                bottomLabelPanel.setPreferredSize(new Dimension(280, 270));
                bottomLabelPanel.setLayout(new BoxLayout(bottomLabelPanel, BoxLayout.Y_AXIS));

                // Add TextMoneyLabel components with spacing
                new TextMoneyLabel(bottomLabelPanel, "Aluguel", home.getCostToStay().get(0));
                bottomLabelPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                new TextMoneyLabel(bottomLabelPanel, "Casa", home.getCostToStay().get(1));
                bottomLabelPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                new TextMoneyLabel(bottomLabelPanel, "Hotel", home.getCostToStay().get(2));
                bottomLabelPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                new TextMoneyLabel(bottomLabelPanel, "Shopping", home.getCostToStay().get(3));
                bottomLabelPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                new TextMoneyLabel(bottomLabelPanel, "Comprar Casa", home.getValueToBuild());
                bottomLabelPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                new TextMoneyLabel(bottomLabelPanel, "Comprar Hotel", home.getValueToBuild());
                bottomLabelPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                new TextMoneyLabel(bottomLabelPanel, "Comprar Shopping", home.getValueToBuild());

                // Add topLabelPanel and bottomLabelPanel to the main panel
                houseDescPanel.add(topLabelPanel, BorderLayout.NORTH);
                houseDescPanel.add(bottomLabelPanel, BorderLayout.CENTER);
            }
        }
    }

}
