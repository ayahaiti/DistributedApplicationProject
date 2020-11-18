package metier.controller;



import javax.swing.*;
import java.util.*;

public class Initialization {



    public boolean checkFields(List<String> fieldsInformation) {
        boolean fieldsComplete = true;
        if (fieldsInformation.size() < 10 || fieldsInformation.contains("ex: C9")) {
            fieldsComplete = false;
        }
        return fieldsComplete;
    }

    public boolean respectLocationFormat(String location) {
        List<Character> lettersAllowed = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
        List<Integer> numbersAllowed = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        boolean locationIsValid = false;
        if (location.length() == 2) {
            char letterNumber[] = location.toCharArray();
            if (lettersAllowed.contains(letterNumber[0])) {
                locationIsValid = true;
            }
        }
        if (location.length() == 3) {
            char letterNumber[] = location.toCharArray();
            if (lettersAllowed.contains(letterNumber[0]) && letterNumber[1] == '1' && letterNumber[2] == '0') {
                locationIsValid = true;
            }
        }
        return locationIsValid;
    }

    public boolean validateLocationFormat(List<String> shipsInfo) {
        boolean validLocationFormat = true;
        //locations should be in the following form: letter(A to J) + number(1 to 10)
        for (int i = 1; i < shipsInfo.size(); i = i + 2) {
            if (!respectLocationFormat(shipsInfo.get(i))) {
                validLocationFormat = false;
            }
        }
        return validLocationFormat;
    }

    public boolean validateLocationsOfShips(List<String> shipsInfo) {
        boolean validLocations = true;
        Set<String> set = new HashSet<String>(shipsInfo);
        if (set.size() < shipsInfo.size()) {
            validLocations = false;
        }
        return validLocations;
    }

    public List<String> getButtonsAccordingToOrientation(int i, String startButton, String orientation) {
        List<String> oneShipButtons = new ArrayList<>();
        String buttonStart[] = startButton.split("");
        String letter = buttonStart[0];
        String number = "";
        if (startButton.length() > 2) {
            number = buttonStart[1] + buttonStart[2];
        } else {
            number = buttonStart[1];
        }
        int newNumber = Integer.valueOf(number);
        int newLetter = (letter.charAt(0) & 31);
        if (i == 0) {
            //5 buttons
            if (orientation.equals("vertical")) {
                for (int j = 0; j < 5; j++) {
                    String button = letter + (newNumber);
                    oneShipButtons.add(button);
                    newNumber = newNumber + 1;
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    char g = (char) (newLetter + 64);
                    String button = g + number;
                    oneShipButtons.add(button);
                    newLetter++;
                }
            }
        }
        if (i == 2) {
            //4 buttons
            if (orientation.equals("vertical")) {
                for (int j = 0; j < 4; j++) {
                    String button = letter + (newNumber);
                    oneShipButtons.add(button);
                    newNumber = newNumber + 1;
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    char g = (char) (newLetter + 64);
                    String button = g + number;
                    oneShipButtons.add(button);
                    newLetter++;
                }
            }
        }
        if (i == 4) {
            //3 buttons
            if (orientation.equals("vertical")) {
                for (int j = 0; j < 3; j++) {
                    String button = letter + (newNumber);
                    oneShipButtons.add(button);
                    newNumber = newNumber + 1;
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    char g = (char) (newLetter + 64);
                    String button = g + number;
                    oneShipButtons.add(button);
                    newLetter++;
                }
            }
        }
        if (i == 6) {
            //3 buttons
            if (orientation.equals("vertical")) {
                for (int j = 0; j < 3; j++) {
                    String button = letter + (newNumber);
                    oneShipButtons.add(button);
                    newNumber = newNumber + 1;
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    char g = (char) (newLetter + 64);
                    String button = g + number;
                    oneShipButtons.add(button);
                    newLetter++;
                }
            }
        }
        if (i == 8) {
            //2 buttons
            if (orientation.equals("vertical")) {
                for (int j = 0; j < 2; j++) {
                    String button = letter + (newNumber);
                    oneShipButtons.add(button);
                    newNumber = newNumber + 1;
                }
            } else {
                for (int j = 0; j < 2; j++) {
                    char g = (char) (newLetter + 64);
                    String button = g + number;
                    oneShipButtons.add(button);
                    newLetter++;
                }
            }
        }
        return oneShipButtons;
    }

    public List<String> getShipsButtons(List<String> shipsInfo) {
        List<String> shipsButtons = new ArrayList<>();
        for (int i = 0; i < shipsInfo.size(); i = i + 2) {
            String startButton = shipsInfo.get(i + 1);
            String orientation = shipsInfo.get(i);
            List<String> oneShipButtons = getButtonsAccordingToOrientation(i, startButton, orientation);
            for (int j = 0; j < oneShipButtons.size(); j++) {
                shipsButtons.add(oneShipButtons.get(j));
            }
        }
        return shipsButtons;
    }

    public boolean areLocationsPossible(List<String> shipsInfo) {
        boolean possibleLocations = true;
        for (int i = 0; i < shipsInfo.size(); i = i + 2) {
            String startButton = shipsInfo.get(i + 1);
            String orientation = shipsInfo.get(i);
            String theButtonStart[] = startButton.split("");
            String letter = theButtonStart[0];
            String number = "";
            if (startButton.length() > 2) {
                number = theButtonStart[1] + theButtonStart[2];
            } else {
                number = theButtonStart[1];
            }
            int newNumber = Integer.valueOf(number);
            int newLetter = (letter.charAt(0) & 31);
            if (i == 0) {
                if (orientation.equals("vertical") && newNumber > 6) {
                    possibleLocations = false;
                } else if (orientation.equals("horizontal") && newLetter>6) {
                    possibleLocations = false;
                }
            }
            if (i == 2) {
                if (orientation.equals("vertical") && newNumber > 7) {
                    possibleLocations = false;
                } else if (orientation.equals("horizontal") && newLetter>7){
                    possibleLocations = false;
                }
            }
            if (i == 4) {
                if (orientation.equals("vertical") && newNumber > 8) {
                    possibleLocations = false;
                } else if (orientation.equals("horizontal") && newLetter>8){
                    possibleLocations = false;
                }
            }
            if (i == 6) {
                if (orientation.equals("vertical") && newNumber>8) {
                    possibleLocations = false;
                } else if (orientation.equals("horizontal") && newLetter>8) {
                    possibleLocations = false;
                }
            }
            if (i == 8) {
                if (orientation.equals("vertical") && newNumber>9) {
                    possibleLocations = false;
                } else if (orientation.equals("horizontal") && newLetter>9) {
                    possibleLocations = false;
                }
            }
        }
        return possibleLocations;
    }

    public static void setButton(JButton jButton, String color){
        if(color.equals("black")) {
            Icon black_cross = new ImageIcon("src/black_cross.png");
            jButton.setIcon(black_cross);
        } else if(color.equals("red")){
            Icon red_icon = new ImageIcon("src/red_cross.png");
            jButton.setIcon(red_icon);
        }

    }

    public static void findAndSetButtonOfCoordinates(JButton b[][], int column, int line, String color){
        String buttonName = column + "" + line;
            for(int i=0; i<b.length; i++){
                for (int j=0; j<b[0].length; j++){
                    if(b[i][j].getName().equals(buttonName)){
                        if(color.equals("red")) {
                            setButton(b[i][j], "red");
                        }
                        else if(color.equals("black")){
                            setButton(b[i][j], "black");
                        }
                    }
                }
            }
    }

    public static void addHitOrMissAction(JButton b[][], String location, String color){
        String theButtonStart[] = location.split("");
        String letter = theButtonStart[0];
        String number = "";
        if (location.length() > 2) {
            number = theButtonStart[1] + theButtonStart[2];
        } else {
            number = theButtonStart[1];
        }
        int newNumber = Integer.valueOf(number);
        int newLetter = (letter.charAt(0) & 31);

        //TODO validate the location (check if the button in enemy's grid contains any ship part)

        findAndSetButtonOfCoordinates(b, newLetter, newNumber, color);
    }
}
