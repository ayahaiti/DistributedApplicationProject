package metier.controller;

import interfaces.PlayGrid;
import metier.beans.Grid;
import metier.beans.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public static List<Player> players = new ArrayList<>();
    private static Grid sharedGrid = new Grid();
    private Initialization initialization = new Initialization();

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

    public static void addNewPlayer(String player_name, List<String> playerShips){
        Player player = new Player(player_name, playerShips);
        players.add(player);
    }

    public static String findOutHitOrMiss(String targetButton, String player_name){
        String color = "";
        boolean a = players.get(0).getPlayer_name().equals(player_name);
        boolean b = players.get(1).getShips().contains(targetButton);
        if((players.get(0).getPlayer_name().equals(player_name) && players.get(1).getShips().contains(targetButton))
        || (players.get(1).getPlayer_name().equals(player_name) && players.get(0).getShips().contains(targetButton))){
            color = "red";
        }
        else {
            color = "black";
        }
        return color;
    }


    public void fire(PlayGrid p,String targetButton, List<String> myShips, String player_name) {
        p.error.setText("");
        for(int i=0; i<this.players.size(); i++) {
            if(this.players.get(i).getPlayer_name().equals(player_name)){
                boolean inputFormatValid = initialization.respectLocationFormat(targetButton);
                if(inputFormatValid == false){
                    p.error.setText("NonValid Location(s) Format");
                }
                else {
                    String color = findOutHitOrMiss(targetButton, player_name);
                    initialization.addHitOrMissAction(p.b, targetButton, color);
                }
            }
        }
    }
}
