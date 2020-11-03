package gameInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShipLocationChoiceInterface extends JFrame implements ActionListener {

    static JButton b[][] = new JButton[11][11];

    static JPanel mainPanel = new JPanel(new BorderLayout());
    static JPanel gridPanel = new JPanel(new GridLayout(11, 11));
    static JPanel firePanel = new JPanel();
    static JLabel title_label = new JLabel("Choose your ships' locations");

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


    JPanel jPanels[] = {carrierPanel, battleshipPanel, cruiserPanel, submarinesPanel, destroyerPanel };

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



    static JLabel carrierShip = new JLabel("Carrier:          ");
    static JLabel battleShip = new JLabel("BattleShip:   ");
    static JLabel cruiserShip = new JLabel("Cruiser:         ");
    static JLabel submarinesShip = new JLabel("Submarines:");
    static JLabel destroyerShip = new JLabel("Destroyer:     ");



    static JButton fireButton = new JButton("ADD");

        public ShipLocationChoiceInterface(String title)
        {
            super(title);
            BoxLayout boxLayout = new BoxLayout(firePanel, BoxLayout.Y_AXIS);
            firePanel.setLayout(boxLayout);
            fireButton.setPreferredSize(new Dimension(70,30));
            fireButton.setBackground(Color.BLUE);
            fireButton.setForeground(Color.WHITE);
            firePanel.add(title_label);

            carrierButton.add(carrierCheckBoxHorizontal);
            carrierButton.add(carrierCheckBoxVertical);
            battleshipButton.add(battleCheckBoxHorizontal);
            battleshipButton.add(battleCheckBoxVertical);
            cruiserButton.add(cruiserCheckBoxHorizontal);
            cruiserButton.add(cruiserCheckBoxVertical);
            submarinesButton.add(submarineCheckBoxHorizontal);
            submarinesButton.add(submarineCheckBoxVertical);
            destroyerButton.add(destroyerCheckBoxHorizontal);
            destroyerButton.add(destroyerCheckBoxVertical);

            carrierPanel.add(carrierShip);
            battleshipPanel.add(battleShip);
            cruiserPanel.add(cruiserShip);
            submarinesPanel.add(submarinesShip);
            destroyerPanel.add(destroyerShip);

            for(int i=0; i<5; i++){
                jPanels[i].add(new JLabel("Location"));
                jPanels[i].add(new JTextField("ex: C9"));
            }

            carrierPanel.add(carrierCheckBoxHorizontal);
            battleshipPanel.add(battleCheckBoxHorizontal);
            cruiserPanel.add(cruiserCheckBoxHorizontal);
            submarinesPanel.add(submarineCheckBoxHorizontal);
            destroyerPanel.add(destroyerCheckBoxHorizontal);

            carrierPanel.add(carrierCheckBoxVertical);
            battleshipPanel.add(battleCheckBoxVertical);
            cruiserPanel.add(cruiserCheckBoxVertical);
            submarinesPanel.add(submarineCheckBoxVertical);
            destroyerPanel.add(destroyerCheckBoxVertical);

            firePanel.add(carrierPanel);
            firePanel.add(battleshipPanel);
            firePanel.add(cruiserPanel);
            firePanel.add(submarinesPanel);
            firePanel.add(destroyerPanel);

            firePanel.add(fireButton);
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
            gridPanel.setPreferredSize(new Dimension(550,400));
            mainPanel.add(firePanel, BorderLayout.NORTH);
            mainPanel.add(gridPanel, BorderLayout.SOUTH);
            getContentPane().add(mainPanel);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ((JButton)ae.getSource()).setBackground(Color.red);
        }


        public static void main(String[] args) {
            ShipLocationChoiceInterface t =new ShipLocationChoiceInterface("Game window");
            t.setSize(600, 700);
            t.setLocationRelativeTo(null);
            t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            t.setVisible(true);
        }

}

