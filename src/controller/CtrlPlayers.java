package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import model.HousePanel;
import model.Player;

public class CtrlPlayers {

    private static Integer order = 0;

    private synchronized static void movePlayer(Player player, HousePanel fromHouse, HousePanel toHouse) {
        fromHouse.removePlayer(player); 
        toHouse.addPlayer(player); 
        player.setCurrentHouse(toHouse);
    }

    public static int[] rollDice(CtrlGame game, JButton button, JLabel label) {

        Player player = game.players.get(getOrder());

        HousePanel playerHouse = player.getCurrentHouse();

        Random random = new Random();

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        int houseIndex = game.table.indexOf(playerHouse);
        int nextHouseIndex = (houseIndex + dice1 + dice2) % 36;

        animatePlayerMove(player, game.table, nextHouseIndex, () -> {
            movePlayer(player, playerHouse, game.table.get(nextHouseIndex));
            nextPlayer();
            button.setEnabled(true);
            label.setText("Vez do Jogador: " + game.players.get(CtrlPlayers.getOrder()).getName());
        });

        return new int[] { dice1, dice2 };
    }

    private static void animatePlayerMove(Player player, ArrayList<HousePanel> table, int targetIndex,
            Runnable onComplete) {
        int startIndex = table.indexOf(player.getCurrentHouse());
        Timer moveTimer = new Timer(500, null); 

        moveTimer.addActionListener(new ActionListener() {
            int currentIndex = startIndex;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove o jogador da casa atual
                table.get(currentIndex).removePlayer(player);

                // Atualiza o índice para a próxima casa
                currentIndex = (currentIndex + 1) % table.size();

                // Adiciona o jogador na próxima casa, a menos que seja a casa de destino
                if (currentIndex != targetIndex) {
                    table.get(currentIndex).addPlayer(player);
                }

                // Atualiza a referência da casa atual do jogador
                player.setCurrentHouse(table.get(currentIndex));

                // Verifica se o jogador chegou ao destino
                if (currentIndex == targetIndex) {
                    ((Timer) e.getSource()).stop();
                    // Chama o callback após a animação terminar
                    if (onComplete != null) {
                        onComplete.run();
                    }
                }
            }
        });

        moveTimer.start(); // Inicia a animação de movimento
    }

    public static Integer getOrder() {
        return order;
    }

    public static void nextPlayer() {
        if (order + 1 == CtrlStarter.getPlayers().size())
            order = 0;
        else
            order++;
    }

}
