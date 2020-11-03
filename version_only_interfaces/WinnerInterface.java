package gameInterfaces;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

public class WinnerInterface {

    static String youwon = "YOU WON";
    static JFrame jFrame = new JFrame();
    static JLabel textLabel = new JLabel( youwon, JLabel.CENTER);




    public static void styleFrame(){
        Dimension dimension = new Dimension(500, 200);
        jFrame.setPreferredSize(dimension);
        jFrame.getContentPane().setBackground(Color.GREEN);
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


    public static void main(String[] args) {
        initFrame();
    }

}
