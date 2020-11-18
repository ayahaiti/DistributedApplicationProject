package interfaces;

import javax.swing.*;
import java.awt.*;

public class LoserInterface extends JFrame{

    static String youlost = "YOU LOST";
    static JFrame jFrame = new JFrame();
    static JLabel textLabel = new JLabel(youlost, JLabel.CENTER);



    public static void styleFrame(){
        Dimension dimension = new Dimension(500, 200);
        jFrame.setPreferredSize(dimension);
        jFrame.getContentPane().setBackground(Color.RED);
    }

    public static void styleJLabel(){
        textLabel.setForeground(Color.BLACK);
        textLabel.setFont(new Font("Serif", Font.BOLD, 20));
    }

    public static void initFrame(){
        styleFrame();
        styleJLabel();
        jFrame.add(textLabel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }


    public void runLoserInterface() {
        initFrame();
    }


}
