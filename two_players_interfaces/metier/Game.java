package metier.controller;

import metier.beans.Grid;
import metier.beans.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static List<Player> players = new ArrayList<>();
    private static Grid sharedGrid = new Grid();

    public Game(){
    }

    public Game(List<Player> players){
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addNewPlayer(String player_name, List<String> playerShips){
        Player player = new Player(player_name, playerShips);
        players.add(player);
    }


    public void play(){

    }




}
