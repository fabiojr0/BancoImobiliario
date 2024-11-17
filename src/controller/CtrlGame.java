package controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import model.HousePanel;
import model.Player;

public class CtrlGame {

    public ArrayList<HousePanel> table = new ArrayList<>();
    public ArrayList<Player> players = CtrlStarter.getPlayers();
    private PropertyChangeSupport support;

    public CtrlGame() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    // Remove um listener
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public ArrayList<HousePanel> getTable() {
        return table;
    }

    public void setTable(ArrayList<HousePanel> table) {
        ArrayList<HousePanel> oldTable = this.table;
        this.table = table;
        support.firePropertyChange("table", oldTable, table);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        ArrayList<Player> oldPlayers = this.players;
        this.players = players;
        support.firePropertyChange("players", oldPlayers, players);
    }
}
