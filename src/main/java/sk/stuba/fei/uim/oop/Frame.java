package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    GameScreen gs;
    ButtonsScreen buttons;

    public Frame(Layout layout,int CELL_SIZE){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(30+CELL_SIZE*layout.getGrid().length,130+CELL_SIZE*layout.getGrid().length);
        setTitle("Richard's maze");
        setLayout(new BorderLayout());
        this.buttons = new ButtonsScreen();
        this.gs = new GameScreen(layout,CELL_SIZE);
        add("North",buttons);
        add("Center",gs);
        repaint();
        setVisible(true);


    }
}
