package gameInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialGrid extends JFrame implements ActionListener{

        static JButton b[][] = new JButton[11][11];

        static JPanel mainPanel = new JPanel(new BorderLayout());
        static JPanel gridPanel = new JPanel(new GridLayout(11, 11));
        static JPanel firePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        static JButton fireButton = new JButton("FIRE");
        static JTextField jTextField = new JTextField();


        public InitialGrid(String title)
        {
            super(title);
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
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ((JButton)ae.getSource()).setBackground(Color.red);
        }

        public static void main(String[] args) {
            InitialGrid t =new InitialGrid("Game window");
            t.setSize(800, 500);
            t.setLocationRelativeTo(null);
            t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            t.setVisible(true);

        }


}

