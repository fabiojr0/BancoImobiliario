package model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class HousePanel {
    private House house;
    private JPanel panel; // Este será o painel associado
    private ArrayList<Player> playersInHouse = new ArrayList<Player>();

    public HousePanel(House house, JPanel panel) {
        setHouse(house);
        setPanel(panel);
        if (panel != null) {
            // Configura o layout para ser uma grade 2x2
            panel.setLayout(new GridLayout(2, 2));
        }
    }

    public synchronized void removePlayer(Player player) {
        Iterator<Player> iterator = playersInHouse.iterator();
        while (iterator.hasNext()) {
            Player p = iterator.next();
            if (p.getName().equals(player.getName())) {
                iterator.remove(); // Remoção segura
                break;
            }
        }
        updatePanel(); // Atualiza a interface gráfica após a remoção
    }

    public synchronized void addPlayer(Player player) {
        playersInHouse.add(player); // Adiciona o jogador na lista
        updatePanel(); // Atualiza a interface gráfica
    }

    private synchronized void updatePanel() {
        panel.removeAll(); // Remove todos os componentes visuais do painel

        for (Player p : playersInHouse) {
            // Cria um JLabel usando o ícone do jogador
            ImageIcon playerIcon = p.getIcon();
            JLabel playerLabel = new JLabel(playerIcon);
            panel.add(playerLabel); // Adiciona o JLabel ao painel
        }

        // Preenche os espaços restantes com JLabels vazios se houver menos de 4 jogadores
        int emptySlots = 4 - playersInHouse.size();
        for (int i = 0; i < emptySlots; i++) {
            panel.add(new JLabel()); // Adiciona JLabels vazios para preencher o grid
        }

        panel.revalidate();
        panel.repaint();
    }
    
    // Getters e Setters
    public ArrayList<Player> getPlayersInHouse() {
        return playersInHouse;
    }

    public void setPlayersInHouse(ArrayList<Player> playersInHouse) {
        this.playersInHouse = playersInHouse;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
        if (panel != null) {
            // Configura o layout para ser uma grade 2x2
            panel.setLayout(new GridLayout(2, 2));
        }
    }
}
