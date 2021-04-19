package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    GameScreen gs;
    ButtonsScreen buttons;

    public Frame(Layout layout){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,900);
        setTitle("Richard's maze");
        setLayout(new BorderLayout());
        this.buttons = new ButtonsScreen();
        this.gs = new GameScreen(layout);
        add("North",buttons);
        add("Center",gs);
        repaint();
        setVisible(true);


    }
}
