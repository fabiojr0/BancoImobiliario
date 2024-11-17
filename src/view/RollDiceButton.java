package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Random;

import controller.CtrlGame;
import controller.CtrlPlayers;

public class RollDiceButton {

    public RollDiceButton(JLayeredPane layeredPane, CtrlGame game) {

        JPanel panel = new JPanel();
        panel.setBounds(774, 402, 280, 300);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Altera o layout para BoxLayout

        JLabel label = new JLabel();
        label.setText("Vez do Jogador: " + game.players.get(CtrlPlayers.getOrder()).getName());
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Centraliza o label
        panel.add(label);

        panel.add(Box.createVerticalStrut(10)); // Adiciona um espaço vertical entre o label e o botão

        JButton Mover = new JButton("Jogar Dados");
        Mover.setPreferredSize(new Dimension(140, 30)); // Define um tamanho preferencial para o botão
        Mover.setMaximumSize(new Dimension(140, 30)); // Define um tamanho máximo para garantir que ele não fique maior
        Mover.setAlignmentX(JButton.CENTER_ALIGNMENT); // Centraliza o botão horizontalmente no painel
        panel.add(Mover);

        panel.add(Box.createVerticalStrut(10)); // Adiciona um espaço vertical entre o botão e o painel de dados

        // Cria um painel para mostrar as imagens dos dois dados
        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Layout com uma linha e duas colunas, com gap horizontal
        JLabel diceLabel1 = new JLabel();
        JLabel diceLabel2 = new JLabel();
        dicePanel.add(diceLabel1);
        dicePanel.add(diceLabel2);
        dicePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT); // Centraliza o painel de dados
        panel.add(dicePanel);

        Mover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Mover.setEnabled(false);

                panel.revalidate();
                panel.repaint();

                Random random = new Random();

                Timer timer = new Timer(100, new ActionListener() {
                    int elapsed = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Gera números aleatórios para os dados
                        int tempDice1 = random.nextInt(6) + 1;
                        int tempDice2 = random.nextInt(6) + 1;

                        // Caminhos temporários para as imagens
                        String tempImagePath1 = "/images/dice" + tempDice1 + ".png";
                        String tempImagePath2 = "/images/dice" + tempDice2 + ".png";

                        URL tempImageUrl1 = RollDiceButton.class.getResource(tempImagePath1);
                        URL tempImageUrl2 = RollDiceButton.class.getResource(tempImagePath2);

                        if (tempImageUrl1 != null && tempImageUrl2 != null) {
                            diceLabel1.setIcon(new ImageIcon(tempImageUrl1));
                            diceLabel2.setIcon(new ImageIcon(tempImageUrl2));
                        }

                        panel.revalidate();
                        panel.repaint();

                        elapsed += 100;
                        // Verifica se passaram 1 segundo (1000ms)
                        if (elapsed >= 1000) {
                            ((Timer) e.getSource()).stop();

                            // Agora obtém os resultados finais dos dados
                            int[] diceResults = CtrlPlayers.rollDice(game, Mover, label);
                            int finalDice1 = diceResults[0];
                            int finalDice2 = diceResults[1];

                            // Define os caminhos para as imagens finais
                            String finalImagePath1 = "/images/dice" + finalDice1 + ".png";
                            String finalImagePath2 = "/images/dice" + finalDice2 + ".png";

                            URL finalImageUrl1 = RollDiceButton.class.getResource(finalImagePath1);
                            URL finalImageUrl2 = RollDiceButton.class.getResource(finalImagePath2);

                            if (finalImageUrl1 != null && finalImageUrl2 != null) {
                                diceLabel1.setIcon(new ImageIcon(finalImageUrl1));
                                diceLabel2.setIcon(new ImageIcon(finalImageUrl2));
                            }

                            panel.revalidate();
                            panel.repaint();
                        }
                    }
                });

                timer.start();
            }
        });

        layeredPane.add(panel);
    }
}
