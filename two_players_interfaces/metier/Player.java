package metier.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    static Grid gridCopy;

    private String player_name;
    private List<String> ships ;

    private static List<String> locationsHit = new ArrayList<>();
    private static  List<String> locationsMissed = new ArrayList<>();
    private static int enemyShipsEarned = 0; //if equals 17 => winner

    private static boolean winner = false;

    public Player(String player_id, List<String> ships) {
        this.player_name = player_id;
        this.ships = ships;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_id(String player_name) {
        this.player_name = player_name;
    }

    public static int getEnemyShipsEarned() {
        return enemyShipsEarned;
    }

    public static void setEnemyShipsEarned(int enemyShipsEarned) {
        Player.enemyShipsEarned = enemyShipsEarned;
    }

    public static Grid getGridCopy() {
        return gridCopy;
    }

    public static void setGridCopy(Grid gridCopy) {
        Player.gridCopy = gridCopy;
    }

    public static List<String> getLocationsHit() {
        return locationsHit;
    }

    public static void setLocationsHit(List<String> locationsHit) {
        Player.locationsHit = locationsHit;
    }

    public static List<String> getLocationsMissed() {
        return locationsMissed;
    }

    public static void setLocationsMissed(List<String> locationsMissed) {
        Player.locationsMissed = locationsMissed;
    }

    public static boolean isWinner() {
        return winner;
    }

    public static void setWinner(boolean winner) {
        Player.winner = winner;
    }
}
