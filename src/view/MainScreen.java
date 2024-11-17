package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.CtrlGame;
import controller.CtrlStarter;
import model.HousePanel;

public class MainScreen extends JFrame {

	private Integer imageSize = 656;

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MainScreen frame = new MainScreen();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		CtrlGame game = new CtrlGame();

		// Inicializa as casas do tabuleiro
		for (int i = 0; i < 36; i++) {
			game.table.add(new HousePanel(CtrlStarter.getTable().get(i), null));
		}

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		getContentPane().add(layeredPane);

		JLabel imageLabel = new JLabel();
		layeredPane.setLayer(imageLabel, 0);
		imageLabel.setBounds(100, 0, 900, imageSize);
		layeredPane.add(imageLabel);

		ImageIcon originalIcon = new ImageIcon(MainScreen.class.getResource("/images/Table.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(this.getHeight() - 60, this.getHeight() - 60,
				Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(scaledImage));

		JPanel settingsPanel = new JPanel();
		settingsPanel.setOpaque(false);
		settingsPanel.setBounds(100, 0, 629, 634);
		layeredPane.setLayer(settingsPanel, 2);
		layeredPane.add(settingsPanel);
		settingsPanel.setLayout(null);

		// Adiciona os painéis de casas e jogadores
		addHousePanels(settingsPanel, game);

		new HouseDesc(layeredPane, game);

		new RollDiceButton(layeredPane, game);

		// Adiciona jogadores às casas iniciais
		for (int i = 0; i < game.players.size() && i < game.table.size(); i++) {
			game.table.get(0).addPlayer(game.players.get(i));
			game.players.get(i).setCurrentHouse(game.table.get(0));
		}

		setVisible(true);
	}

	private void addHousePanels(JPanel settingsPanel, CtrlGame game) {
		int[][] positions = { { 552, 555 }, { 493, 555 }, { 434, 555 }, { 375, 555 }, { 316, 555 }, { 257, 555 },
				{ 198, 555 }, { 139, 555 }, { 80, 555 }, { 0, 555 }, { 0, 496 }, { 0, 437 }, { 0, 378 }, { 0, 319 },
				{ 0, 260 }, { 0, 201 }, { 0, 142 }, { 0, 83 }, { 0, 4 }, { 79, 4 }, { 138, 4 }, { 197, 4 }, { 256, 4 },
				{ 315, 4 }, { 374, 4 }, { 433, 4 }, { 492, 4 }, { 551, 4 }, { 551, 83 }, { 551, 142 }, { 551, 201 },
				{ 551, 260 }, { 551, 319 }, { 551, 378 }, { 551, 437 }, { 551, 496 } };

		Dimension sizeCorner = new Dimension(79, 80);
		Dimension sizeSide = new Dimension(59, 80);
		Dimension sizeSideRotated = new Dimension(80, 59);

		for (int i = 0; i < positions.length; i++) {
			JPanel housePanel = new JPanel();
			game.table.get(i).setPanel(housePanel);

			// Configura o tamanho e a posição do painel da casa
			if (i % 9 == 0) {
				housePanel.setPreferredSize(sizeCorner);
				housePanel.setBounds(
						new Rectangle(positions[i][0], positions[i][1], sizeCorner.width, sizeCorner.height));
			} else {
				if ((i > 9 && i < 18) || (i > 27)) {
					housePanel.setPreferredSize(sizeSideRotated);
					housePanel.setBounds(new Rectangle(positions[i][0], positions[i][1], sizeSideRotated.width,
							sizeSideRotated.height));
				} else {
					housePanel.setPreferredSize(sizeSide);
					housePanel.setBounds(
							new Rectangle(positions[i][0], positions[i][1], sizeSide.width, sizeSide.height));
				}
			}

			housePanel.setOpaque(false);
			settingsPanel.add(housePanel);
		}
	}

}
