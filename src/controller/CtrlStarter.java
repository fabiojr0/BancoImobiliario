package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import model.Company;
import model.Game;
import model.Home;
import model.House;
import model.LuckyOrUnlucky;
import model.Player;

public class CtrlStarter {
	private static ArrayList<House> table = new ArrayList<>(Arrays.asList(
			new House("Início", "Receba R$200", Color.yellow),
			new Home("Av. Niemayer", null, Color.green, Home.Family.Green, 75.00, 50.00,
					new ArrayList<Double>(Arrays.asList(2.00, 10.00, 30.00, 90.00))),
			new LuckyOrUnlucky(),
			new Company("Companhia de Luz", null, Color.gray, 200.00, 50.00),
			new Home("Av. Beira Mar", null, Color.green, Home.Family.Green, 60.00, 50.00,
					new ArrayList<Double>(Arrays.asList(4.00, 20.00, 60.00, 180.00))),
			new LuckyOrUnlucky(),
			new Home("Rua Oscar Freire", null, Color.red, Home.Family.Red, 220.00, 150.00,
					new ArrayList<Double>(Arrays.asList(18.00, 90.00, 250.00, 700.00))),
			new Company("Companhia de Água", null, Color.gray, 200.00, 50.00),
			new Home("Av. Ibirapuera", null, Color.red, Home.Family.Red, 220.00, 150.00,
					new ArrayList<Double>(Arrays.asList(18.00, 90.00, 250.00, 700.00))),
			new House("Prisão", null, Color.green), new LuckyOrUnlucky(),
			new Home("Praça da Sé", null, Color.blue, Home.Family.Blue, 200.00, null, null),
			new Company("Companhia Petrolífera", null, Color.gray, 200.00, 50.00),
			new Home("Rua da Conceição", null, Color.blue, Home.Family.Blue, 150.00, 100.00,
					new ArrayList<Double>(Arrays.asList(14.00, 70.00, 200.00, 550.00))),
			new House("Construtora", null, Color.gray),
			new Home("Higienópolis", null, Color.pink, Home.Family.Pink, 400.00, 200.00,
					new ArrayList<Double>(Arrays.asList(35.00, 175.00, 500.00, 1100.00))),
			new Home("Jardins", null, Color.pink, Home.Family.Pink, 330.00, 200.00,
					new ArrayList<Double>(Arrays.asList(50.00, 200.00, 600.00, 1400.00))),
			new Home("Av. São João", null, Color.magenta, Home.Family.Magenta, 120.00, 50.00,
					new ArrayList<Double>(Arrays.asList(6.00, 30.00, 90.00, 270.00))),
			new House("Feriado", null, Color.blue),
			new Home("Av. Ipiranga", null, Color.magenta, Home.Family.Magenta, 100.00, 50.00,
					new ArrayList<Double>(Arrays.asList(8.00, 40.00, 100.00, 300.00))),
			new Company("Companhia Mineradora", null, Color.gray, 200.00, 50.00),
			new House("Compra livre", "", Color.green), new LuckyOrUnlucky(),
			new Home("Ponte do Guaíba", null, Color.magenta, Home.Family.Magenta, 140.00, 100.00,
					new ArrayList<Double>(Arrays.asList(10.00, 50.00, 150.00, 450.00))),
			new Home("Av. Paulista", null, Color.magenta, Home.Family.Magenta, 160.00, 100.00,
					new ArrayList<Double>(Arrays.asList(12.00, 60.00, 180.00, 500.00))),
			new Home("Av. Recife", null, Color.magenta, Home.Family.Magenta, 140.00, 100.00,
					new ArrayList<Double>(Arrays.asList(10.00, 50.00, 150.00, 450.00))),
			new Company("Créditos de Carbono", null, Color.gray, 150.00, 50.00),
			new House("Vá para Prisão", null, Color.green),
			new Home("Praça dos 3 poderes", null, Color.orange, Home.Family.Orange, 320.00, 200.00,
					new ArrayList<Double>(Arrays.asList(28.00, 150.00, 450.00, 1000.00))),
			new LuckyOrUnlucky(),
			new Home("Praça Castro Alves", null, Color.orange, Home.Family.Orange, 300.00, 200.00,
					new ArrayList<Double>(Arrays.asList(26.00, 130.00, 390.00, 900.00))),
			new Home("Av. do Contorno", null, Color.orange, Home.Family.Orange, 300.00, 200.00,
					new ArrayList<Double>(Arrays.asList(26.00, 130.00, 390.00, 900.00))),
			new Home("Ponte Rio-Niterói", null, Color.yellow, Home.Family.Yellow, 280.00, 150.00,
					new ArrayList<Double>(Arrays.asList(26.00, 130.00, 360.00, 850.00))),
			new Company("Pontocom", null, Color.gray, 150.00, 50.00),
			new Home("Marina da Glória", null, Color.yellow, Home.Family.Yellow, 260.00, 150.00,
					new ArrayList<Double>(Arrays.asList(22.00, 110.00, 330.00, 800.00))),
			new LuckyOrUnlucky()));

	private static ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(new Player("skeleton"),
			new Player("archer"), new Player("goblin"), new Player("barbarian")));

	private static Game game = new Game(table, players);

	public static ArrayList<House> getTable() {
		return game.getHouses();
	}

	public static ArrayList<Player> getPlayers() {
		return game.getPlayers();
	}

	public static Game getGame() {
		return game;
	}

}
