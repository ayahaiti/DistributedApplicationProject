package interfaces;

import metier.controller.Initialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class twoframes extends JFrame implements ActionListener {

    private JButton b[][] = new JButton[11][11];

    private JButton fireButton;
    private JButton playButton;


    private static List<String>  shipsInfo ;


    private JLabel error;

    private JPanel mainPanel ;
    private JPanel carrierPanel ;
    private JPanel battleshipPanel ;
    private JPanel cruiserPanel ;
    private JPanel submarinesPanel ;
    private JPanel destroyerPanel ;

    private JRadioButton carrierCheckBoxHorizontal = new JRadioButton("horizontal");
    private JRadioButton battleCheckBoxHorizontal = new JRadioButton("horizontal");
    private JRadioButton cruiserCheckBoxHorizontal = new JRadioButton("horizontal");
    private JRadioButton submarineCheckBoxHorizontal = new JRadioButton("horizontal");
    private JRadioButton destroyerCheckBoxHorizontal = new JRadioButton("horizontal");

    private JRadioButton carrierCheckBoxVertical = new JRadioButton("vertical");
    private JRadioButton battleCheckBoxVertical = new JRadioButton("vertical");
    private JRadioButton cruiserCheckBoxVertical = new JRadioButton("vertical");
    private JRadioButton submarineCheckBoxVertical = new JRadioButton("vertical");
    private JRadioButton destroyerCheckBoxVertical = new JRadioButton("vertical");



    private JLabel carrierShip    = new JLabel("Carrier (5 squares)         :");
    private JLabel battleShip     = new JLabel("BattleShip (4 squares)   :");
    private JLabel cruiserShip    = new JLabel("Cruiser (3 squares)       :");
    private JLabel submarinesShip = new JLabel("Submarines (3 squares):");
    private JLabel destroyerShip  = new JLabel("Destroyer: (2 squares)   :");



    public void addSetCarrierShipPanel(JPanel firePanel,JPanel carrierPanel, ButtonGroup carrierButton) {
        carrierButton.add(carrierCheckBoxHorizontal);
        carrierButton.add(carrierCheckBoxVertical);
        carrierPanel.add(carrierShip);
        carrierPanel.add(carrierCheckBoxHorizontal);
        carrierPanel.add(carrierCheckBoxVertical);
        firePanel.add(carrierPanel);
    }

    public void addSetBattleShipPanel(JPanel firePanel, JPanel battleshipPanel, ButtonGroup battleshipButton){
        battleshipButton.add(battleCheckBoxHorizontal);
        battleshipButton.add(battleCheckBoxVertical);
        battleshipPanel.add(battleShip);
        battleshipPanel.add(battleCheckBoxHorizontal);
        battleshipPanel.add(battleCheckBoxVertical);
        firePanel.add(battleshipPanel);
    }

    public void addSetCruiserShipPanel(JPanel firePanel, JPanel cruiserPanel, ButtonGroup cruiserButton){
        cruiserButton.add(cruiserCheckBoxHorizontal);
        cruiserButton.add(cruiserCheckBoxVertical);
        cruiserPanel.add(cruiserShip);
        cruiserPanel.add(cruiserCheckBoxHorizontal);
        cruiserPanel.add(cruiserCheckBoxVertical);
        firePanel.add(cruiserPanel);
    }

    public void addSetSubmarinesShipPanel(JPanel firePanel, JPanel submarinesPanel, ButtonGroup submarinesButton){
        submarinesButton.add(submarineCheckBoxHorizontal);
        submarinesButton.add(submarineCheckBoxVertical);
        submarinesPanel.add(submarinesShip);
        submarinesPanel.add(submarineCheckBoxHorizontal);
        submarinesPanel.add(submarineCheckBoxVertical);
        firePanel.add(submarinesPanel);
    }

    public void addSetDestroyerShipPanel(JPanel firePanel, JPanel destroyerPanel, ButtonGroup destroyerButton){
        destroyerButton.add(destroyerCheckBoxHorizontal);
        destroyerButton.add(destroyerCheckBoxVertical);
        destroyerPanel.add(destroyerShip);
        destroyerPanel.add(destroyerCheckBoxHorizontal);
        destroyerPanel.add(destroyerCheckBoxVertical);
        firePanel.add(destroyerPanel);
    }

    public void addSquaresLabels(JPanel gridPanel, JButton b[][]){
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
    public void addSetLocationInfo(JPanel jPanels[]){
        for(int i=0; i<5; i++){
            JTextField location = new JTextField("ex: C9");
            location.setPreferredSize(new Dimension(40,20));
            jPanels[i].add(new JLabel("     Location "));
            jPanels[i].add(location);
        }
    }

    public void addSetFirePanel(JLabel title_label, JPanel firePanel, JPanel carrierPanel, JPanel cruiserPanel
            , JPanel battleshipPanel, JPanel submarinesPanel, JPanel destroyerPanel, BoxLayout boxLayout,
                                JPanel jPanels[], JButton fireButton, ButtonGroup carrierButton, ButtonGroup battleButton,
                                ButtonGroup cruiserButton, ButtonGroup subMarinesButton, ButtonGroup destroyerButton){
        firePanel.add(title_label);
        firePanel.setLayout(boxLayout);
        fireButton.setPreferredSize(new Dimension(70,30));
        fireButton.setBackground(Color.BLUE);
        fireButton.setForeground(Color.WHITE);
        addSetCarrierShipPanel(firePanel,carrierPanel, carrierButton);
        addSetBattleShipPanel(firePanel, battleshipPanel, battleButton);
        addSetCruiserShipPanel(firePanel, cruiserPanel, cruiserButton);
        addSetSubmarinesShipPanel(firePanel, submarinesPanel, subMarinesButton);
        addSetDestroyerShipPanel(firePanel, destroyerPanel, destroyerButton);
        addSetLocationInfo(jPanels);
        firePanel.add(fireButton);
        firePanel.add(error);
    }

    public void setMainPanel(JPanel firePanel, JPanel gridPanel, JPanel playPanel, JPanel mainPanel, JButton playButton){
        gridPanel.setPreferredSize(new Dimension(550,400));
        playButton.setBackground(Color.white);
        playPanel.add(playButton);
        mainPanel.add(firePanel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(playPanel, BorderLayout.SOUTH);
    }

    public twoframes(String title)
    {
        super(title);
        this.shipsInfo = new ArrayList<>();
        this.fireButton = new JButton("ADD");
        this.playButton = new JButton("Play");
        ButtonGroup carrierButton = new ButtonGroup();
        ButtonGroup battleshipButton = new ButtonGroup();
        ButtonGroup cruiserButton = new ButtonGroup();
        ButtonGroup submarinesButton = new ButtonGroup();
        ButtonGroup destroyerButton = new ButtonGroup();
        error = new JLabel("");
        JLabel title_label = new JLabel("Choose your ships' locations");
        mainPanel = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(11, 11));
        JPanel firePanel = new JPanel();
        JPanel playPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(firePanel, BoxLayout.Y_AXIS);
        carrierPanel = new JPanel();
        battleshipPanel =new JPanel();
        cruiserPanel = new JPanel();
        submarinesPanel = new JPanel();
        destroyerPanel = new JPanel();
        JPanel jPanels[] = {carrierPanel, battleshipPanel, cruiserPanel, submarinesPanel, destroyerPanel };
        List<String> list = getShipsInformation(jPanels);
        for(int i=0; i<list.size(); i++){
            this.shipsInfo.add(list.get(i));
        }
        addSetFirePanel(title_label, firePanel, carrierPanel, cruiserPanel
                , battleshipPanel, submarinesPanel, destroyerPanel, boxLayout, jPanels,
                fireButton, carrierButton, battleshipButton, cruiserButton, submarinesButton, destroyerButton);
        addSquaresLabels(gridPanel, this.b);
        setMainPanel(firePanel, gridPanel, playPanel, mainPanel, playButton);
        getContentPane().add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ((JButton)ae.getSource()).setBackground(Color.red);
    }


    public static List<String> getShipsInformation(JPanel jPanels[]){
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

    public static void addsShipsToGrid(twoframes s, Initialization init){
        //send and receive buttons to mark as my ships in a list
        s.fireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("ADD")){
                    //get ships information from Front-End
                    JPanel jPanels[] = {s.carrierPanel, s.battleshipPanel, s.cruiserPanel, s.submarinesPanel, s.destroyerPanel};
                    s.shipsInfo = getShipsInformation(jPanels);
                    //call to check if all the fields are completed
                    boolean fieldComplete = init.checkFields(s.shipsInfo);
                    //validate locations input
                    boolean validLocationFormat = init.validateLocationFormat(s.shipsInfo);
                    if( fieldComplete) {
                        if (validLocationFormat) {
                            //get complete buttons for ships from chosen locations
                            List<String> myShips = init.getShipsButtons(s.shipsInfo);
                            //call and validate ships locations that have been chosen
                            boolean validLocationChoices = init.validateLocationsOfShips(myShips);
                            boolean possibleLocations = init.areLocationsPossible(s.shipsInfo);
                            if (validLocationChoices) {
                                if(possibleLocations) {
                                    for (int i = 0; i < myShips.size(); i++) {
                                        //find button's name that is equal to myShips.get(i)
                                        for (int x = 1; x < 11; x++) {
                                            for (int y = 1; y < 11; y++) {
                                                if (s.b[x][y].getName().equals(myShips.get(i))) {
                                                    s.b[x][y].setBackground(Color.cyan);
                                                }
                                            }
                                        }
                                    }
                                    s.error.setText("Valid Choices!");
                                    s.error.setForeground(Color.GREEN);
                                    s.fireButton.setEnabled(false);
                                }
                                else {
                                    s.error.setText("Not Possible Locations");
                                    s.error.setForeground(Color.RED);
                                }
                            } else {
                                s.error.setText("Interconnected Locations");
                                s.error.setForeground(Color.RED);
                            }
                        }
                        else {
                            s.error.setText("NonValid Location(s) Format");
                            s.error.setForeground(Color.RED);
                        }
                    }
                    else{
                        s.error.setText("At least one field is empty! Please complete all the fields.");
                        s.error.setForeground(Color.RED);
                    }
                }
            }
        });
        s.playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Play")){
                    if(s.error.getText().equals("Valid Choices!")) {
                        //t.setVisible(false);
                        InitialGrid initialGrid = new InitialGrid("new Game");
                        initialGrid.runPlayGrid();
                    }
                }
            }
        });
        System.out.println(s.error.getText());
    }



    public static void main(String[] args) {
        Initialization init1 = new Initialization();


        twoframes s = new twoframes("g");
        addsShipsToGrid(s, init1);
        s.setSize(600, 700);
        s.setLocationRelativeTo(null);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);

        twoframes s2 = new twoframes("j");
        addsShipsToGrid(s2, init1);
        s2.setSize(600, 700);
        s2.setLocationRelativeTo(null);
        s2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s2.setVisible(true);

    }

}

