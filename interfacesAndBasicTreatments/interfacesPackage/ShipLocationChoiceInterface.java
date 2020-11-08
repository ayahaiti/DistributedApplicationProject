package gameInterfaces;

import metier.controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShipLocationChoiceInterface extends JFrame implements ActionListener {

    static JButton b[][] = new JButton[11][11];

    static Game game = new Game();

    static JPanel mainPanel = new JPanel(new BorderLayout());
    static JPanel gridPanel = new JPanel(new GridLayout(11, 11));
    static JPanel firePanel = new JPanel();
    static JPanel playPanel = new JPanel();

    static JLabel title_label = new JLabel("Choose your ships' locations");
    static JLabel error = new JLabel("");

    static JPanel carrierPanel = new JPanel();
    static JPanel battleshipPanel =new JPanel();
    static JPanel cruiserPanel = new JPanel();
    static JPanel submarinesPanel = new JPanel();
    static JPanel destroyerPanel = new JPanel();

    static ButtonGroup carrierButton = new ButtonGroup();
    static ButtonGroup battleshipButton = new ButtonGroup();
    static ButtonGroup cruiserButton = new ButtonGroup();
    static ButtonGroup submarinesButton = new ButtonGroup();
    static ButtonGroup destroyerButton = new ButtonGroup();


    static JPanel jPanels[] = {carrierPanel, battleshipPanel, cruiserPanel, submarinesPanel, destroyerPanel };

    JRadioButton carrierCheckBoxHorizontal = new JRadioButton("horizontal");
    JRadioButton battleCheckBoxHorizontal = new JRadioButton("horizontal");
    JRadioButton cruiserCheckBoxHorizontal = new JRadioButton("horizontal");
    JRadioButton submarineCheckBoxHorizontal = new JRadioButton("horizontal");
    JRadioButton destroyerCheckBoxHorizontal = new JRadioButton("horizontal");

    JRadioButton carrierCheckBoxVertical = new JRadioButton("vertical");
    JRadioButton battleCheckBoxVertical = new JRadioButton("vertical");
    JRadioButton cruiserCheckBoxVertical = new JRadioButton("vertical");
    JRadioButton submarineCheckBoxVertical = new JRadioButton("vertical");
    JRadioButton destroyerCheckBoxVertical = new JRadioButton("vertical");



    static JLabel carrierShip    = new JLabel("Carrier (5 squares)         :");
    static JLabel battleShip     = new JLabel("BattleShip (4 squares)   :");
    static JLabel cruiserShip    = new JLabel("Cruiser (3 squares)       :");
    static JLabel submarinesShip = new JLabel("Submarines (3 squares):");
    static JLabel destroyerShip  = new JLabel("Destroyer: (2 squares)   :");

    static BoxLayout boxLayout = new BoxLayout(firePanel, BoxLayout.Y_AXIS);

    static JButton fireButton = new JButton("ADD");
    static JButton playButton = new JButton("Play");

    static ShipLocationChoiceInterface t = new ShipLocationChoiceInterface("Game window");


    public void addSetCarrierShipPanel() {
        carrierButton.add(carrierCheckBoxHorizontal);
        carrierButton.add(carrierCheckBoxVertical);
        carrierPanel.add(carrierShip);
        carrierPanel.add(carrierCheckBoxHorizontal);
        carrierPanel.add(carrierCheckBoxVertical);
        firePanel.add(carrierPanel);
    }

    public void addSetBattleShipPanel(){
        battleshipButton.add(battleCheckBoxHorizontal);
        battleshipButton.add(battleCheckBoxVertical);
        battleshipPanel.add(battleShip);
        battleshipPanel.add(battleCheckBoxHorizontal);
        battleshipPanel.add(battleCheckBoxVertical);
        firePanel.add(battleshipPanel);
    }

    public void addSetCruiserShipPanel(){
        cruiserButton.add(cruiserCheckBoxHorizontal);
        cruiserButton.add(cruiserCheckBoxVertical);
        cruiserPanel.add(cruiserShip);
        cruiserPanel.add(cruiserCheckBoxHorizontal);
        cruiserPanel.add(cruiserCheckBoxVertical);
        firePanel.add(cruiserPanel);
    }

    public void addSetSubmarinesShipPanel(){
        submarinesButton.add(submarineCheckBoxHorizontal);
        submarinesButton.add(submarineCheckBoxVertical);
        submarinesPanel.add(submarinesShip);
        submarinesPanel.add(submarineCheckBoxHorizontal);
        submarinesPanel.add(submarineCheckBoxVertical);
        firePanel.add(submarinesPanel);
    }

    public void addSetDestroyerShipPanel(){
        destroyerButton.add(destroyerCheckBoxHorizontal);
        destroyerButton.add(destroyerCheckBoxVertical);
        destroyerPanel.add(destroyerShip);
        destroyerPanel.add(destroyerCheckBoxHorizontal);
        destroyerPanel.add(destroyerCheckBoxVertical);
        firePanel.add(destroyerPanel);
    }

    public void addSquaresLabels(){
        int line = 1;
        char column = 'A';
        char column_ = 'A';
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(i==0 || j==0){
                    b[i][j] = new JButton();
                    if (i != 0){
                        b[i][j].setText(String.valueOf(line));
                        line++;
                    }
                    if (j != 0){
                        b[i][j].setText(String.valueOf(column));
                        column++;
                    }
                    b[i][j].setBackground(Color.WHITE);
                    gridPanel.add(b[i][j]);
                }
                else {
                    b[i][j] = new JButton();
                    String the_line = Integer.toString(line-1);
                    String the_column = String.valueOf(column_++);
                    b[i][j].setName( the_column + the_line );
                    b[i][j].setBackground(Color.LIGHT_GRAY);
                    b[i][j].addActionListener(this);
                    gridPanel.add(b[i][j]);
                }
            }
            column_ = 'A';
        }
    }
    public void addSetLocationInfo(){
        for(int i=0; i<5; i++){
            JTextField location = new JTextField("ex: C9");
            location.setPreferredSize(new Dimension(40,20));
            jPanels[i].add(new JLabel("     Location "));
            jPanels[i].add(location);
        }
    }

    public void addSetFirePanel(){
        firePanel.add(title_label);
        firePanel.setLayout(boxLayout);
        fireButton.setPreferredSize(new Dimension(70,30));
        fireButton.setBackground(Color.BLUE);
        fireButton.setForeground(Color.WHITE);
        addSetCarrierShipPanel();
        addSetBattleShipPanel();
        addSetCruiserShipPanel();
        addSetSubmarinesShipPanel();
        addSetDestroyerShipPanel();
        addSetLocationInfo();
        firePanel.add(fireButton);
        firePanel.add(error);
    }

    public void setMainPanel(){
        gridPanel.setPreferredSize(new Dimension(550,400));
        playButton.setBackground(Color.white);
        playPanel.add(playButton);
        mainPanel.add(firePanel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(playPanel, BorderLayout.SOUTH);
    }

        public ShipLocationChoiceInterface(String title)
        {
            super(title);
            addSetFirePanel();
            addSquaresLabels();
            setMainPanel();
            getContentPane().add(mainPanel);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ((JButton)ae.getSource()).setBackground(Color.red);
        }


        public static List<String> getShipsInformation(){
            List<String> shipsInformation = new ArrayList<>();
            for(int i=0; i<5; i++){
                Component[] components = jPanels[i].getComponents();
                for(Component comp : components){
                    if(comp instanceof JTextField){
                        JTextField location = (JTextField) comp;
                        shipsInformation.add(((JTextField) comp).getText());
                    }
                    if(comp instanceof JRadioButton){
                        JRadioButton radioButton = (JRadioButton) comp;
                        if(radioButton.isSelected()) {
                            shipsInformation.add(radioButton.getText());
                        }
                    }
                }
            }
            return shipsInformation;
        }

        public static void addShipsToGrid(){
         //send and receive buttons to mark as my ships in a list
                fireButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equals("ADD")){
                            //get ships information from Front-End
                            List<String> shipsInfo = getShipsInformation();
                            //call to check if all the fields are completed
                            boolean fieldComplete = game.checkFields(shipsInfo);
                            //validate locations input
                            boolean validLocationFormat = game.validateLocationFormat(shipsInfo);
                            if( fieldComplete) {
                                if (validLocationFormat) {
                                    error.setText("");
                                    //get complete buttons for ships from chosen locations
                                    List<String> myShips = game.getShipsButtons(shipsInfo);
                                    //call and validate ships locations that have been chosen
                                    boolean validLocationChoices = game.validateLocationsOfShips(myShips);
                                    boolean possibleLocations = game.areLocationsPossible(shipsInfo);
                                    if (validLocationChoices) {
                                        if(possibleLocations) {
                                            for (int i = 0; i < myShips.size(); i++) {
                                                //find button's name that is equal to myShips.get(i)
                                                for (int x = 1; x < 11; x++) {
                                                    for (int y = 1; y < 11; y++) {
                                                        if (b[x][y].getName().equals(myShips.get(i))) {
                                                            b[x][y].setBackground(Color.cyan);
                                                        }
                                                    }
                                                }
                                            }
                                            fireButton.setEnabled(false);
                                        }
                                        else {
                                            error.setText("Not Possible Locations");
                                            error.setForeground(Color.RED);
                                        }
                                    } else {
                                        error.setText("Interconnected Locations");
                                        error.setForeground(Color.RED);
                                    }
                                }
                                else {
                                    error.setText("NonValid Location(s) Format");
                                    error.setForeground(Color.RED);
                                }
                            }
                            else{
                                error.setText("At least one field is empty! Please complete all the fields.");
                                error.setForeground(Color.RED);
                            }
                        }
                    }
                });
                playButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equals("Play")){
                            t.setVisible(false);
                            InitialGrid initialGrid = new InitialGrid("new Game");
                            initialGrid.runPlayGrid();
                        }
                    }
                });
        }



        public static void main(String[] args) {
            addShipsToGrid();
            t.setSize(600, 700);
            t.setLocationRelativeTo(null);
            t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            t.setVisible(true);
        }

}

