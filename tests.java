import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class tests extends JFrame implements ActionListener{
    static JButton b[][] = new JButton[11][11];

    static JPanel mainPanel = new JPanel(new BorderLayout());
    static JPanel gridPanel = new JPanel(new GridLayout(11, 11));
    static JPanel firePanel = new JPanel(new BorderLayout());
    static JButton fireButton = new JButton("FIRE");


    public tests(String title)
    {
        super(title);
        firePanel.add(fireButton, BorderLayout.SOUTH);
        int line = 1;
        char column = 'A';
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(i==0 || j==0){
                    b[i][j] = new JButton();
                    if (i != 0){
                        b[i][j].setText((line++) + "");
                    }
                    if (j != 0){
                        b[i][j].setText((column++) + "");
                    }
                    b[i][j].setBackground(Color.WHITE);
                    gridPanel.add(b[i][j]);
                }
                else {
                    b[i][j] = new JButton();
                    b[i][j].setName("");
                    b[i][j].setBackground(Color.LIGHT_GRAY);
                    b[i][j].addActionListener(this);
                    gridPanel.add(b[i][j]);
                }
            }
        }
        mainPanel.add(gridPanel, BorderLayout.NORTH);
        mainPanel.add(firePanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ((JButton)ae.getSource()).setBackground(Color.red);
    }

    public static void main(String[] args) {
        tests t =new tests("Game window");
        t.setVisible(true);
        t.setSize(1000, 600);
    }
}
