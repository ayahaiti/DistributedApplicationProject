package interfaces;

import metier.beans.Player;
import metier.controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayGrid extends JFrame implements ActionListener{

        private JButton b[][] = new JButton[11][11];
        private String player_name;
        private JPanel mainPanel ;
        private JPanel gridPanel ;
        private JPanel firePanel ;
        private JButton fireButton ;
        private JTextField jTextField ;

        static List<PlayGrid> listOfGrids = new ArrayList<>();

        static Game game = new Game();

        public void addPlayersShips(List<String> playersShips) {
            for (int i = 0; i < playersShips.size(); i++) {
                //find button's name that is equal to myShips.get(i)
                for (int x = 1; x < 11; x++) {
                    for (int y = 1; y < 11; y++) {
                        if (this.b[x][y].getName().equals(playersShips.get(i))) {
                            this.b[x][y].setBackground(Color.cyan);
                        }
                    }
                }
            }
        }

        public PlayGrid(String title, List<String> player_ships)
        {
            super(title);
            mainPanel = new JPanel(new BorderLayout());
            gridPanel = new JPanel(new GridLayout(11, 11));
            firePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            fireButton = new JButton("FIRE");
            jTextField = new JTextField();
            jTextField.setPreferredSize(new Dimension(300,30));
            jTextField.setText("Enter enemy location to fire, example : G10 ");
            fireButton.setPreferredSize(new Dimension(70,30));
            fireButton.setBackground(Color.BLACK);
            fireButton.setForeground(Color.WHITE);
            firePanel.add(jTextField);
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
            mainPanel.add(gridPanel, BorderLayout.NORTH);
            mainPanel.add(firePanel, BorderLayout.SOUTH);
            getContentPane().add(mainPanel);
            addPlayersShips(player_ships);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ((JButton)ae.getSource()).setBackground(Color.red);
        }

    static void setLocationToTopRight(JFrame frame) {
        GraphicsConfiguration config = frame.getGraphicsConfiguration();
        Rectangle bounds = config.getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);

        int x = bounds.x + bounds.width - insets.right - frame.getWidth();
        int y = bounds.y + insets.top;
        frame.setLocation(x, y);
    }

        public void runPlayGrid(String player_name){
            this.player_name = player_name;
            this.setSize(600, 500);
            if(player_name.equals("player1")){
                setLocationToTopRight(this);
            }
            else {
                this.setLocation(0,0);
            }
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);

        }

        public void fireEnemy(){
            this.fireButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(game.players.get(0).getShips().size());
                    System.out.println(game.players.size());
                }
            });
        }


        public static void createNewGrids(List<String> myShips, String player_name){
            PlayGrid playGrid = new PlayGrid("new Game", myShips);
            playGrid.runPlayGrid(player_name);
            listOfGrids.add(playGrid);
            playGrid.fireEnemy();
        }


    public static void main(String[] args) {
        twoframes.runInitialGrids(game);
    }

        /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });*/


}

