package metier.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    int number;
    static HashMap<String,Integer> shipsKeys = new HashMap<>();
    static List<String> locationsFired = new ArrayList<>();
    static int enemyShipsEarned = 0; //if equals 17 => winner
    static boolean winner = false;

    public Player(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static HashMap<String, Integer> getShipsKeys() {
        return shipsKeys;
    }

    public static void setShipsKeys(HashMap<String, Integer> shipsKeys) {
        Player.shipsKeys = shipsKeys;
    }

    public static List<String> getLocationsFired() {
        return locationsFired;
    }

    public static void setLocationsFired(List<String> locationsFired) {
        Player.locationsFired = locationsFired;
    }

    public static int getEnemyShipsEarned() {
        return enemyShipsEarned;
    }

    public static void setEnemyShipsEarned(int enemyShipsEarned) {
        Player.enemyShipsEarned = enemyShipsEarned;
    }
}
