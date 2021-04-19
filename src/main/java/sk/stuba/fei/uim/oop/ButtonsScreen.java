package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class ButtonsScreen extends JPanel {

    public ButtonsScreen(){
        setLayout(new GridLayout(2,3));
        add(new JLabel("Counter"));
        JButton up = new JButton("Up");
        JButton right = new JButton("Right");
        JButton left = new JButton("Left");
        JButton down = new JButton("Down");
        JButton reset = new JButton("RESET");

        add(up);
        add(reset);
        add(left);
        add(down);
        add(right);
    }

}
