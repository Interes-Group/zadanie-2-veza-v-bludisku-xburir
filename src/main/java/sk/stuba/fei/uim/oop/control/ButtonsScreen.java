package sk.stuba.fei.uim.oop.control;

import sk.stuba.fei.uim.oop.frontend.Frame;
import sk.stuba.fei.uim.oop.frontend.GameScreen;
import sk.stuba.fei.uim.oop.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonsScreen extends JPanel implements ActionListener {
    private Player player;
    private GameScreen gs;
    private Frame fr;

    public ButtonsScreen(Player player,GameScreen gs, Frame fr){

        this.player = player;
        this.fr = fr;
        this.gs = gs;
        setLayout(new GridLayout(2,3));
        add(new JLabel());

        JButton up = new JButton("Up");
        JButton right = new JButton("Right");
        JButton left = new JButton("Left");
        JButton down = new JButton("Down");
        JButton reset = new JButton("RESET");

        reset.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);

        up.setFocusable(false);
        down.setFocusable(false);
        left.setFocusable(false);
        right.setFocusable(false);
        reset.setFocusable(false);

        add(up);
        add(reset);
        add(left);
        add(down);
        add(right);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("RESET")){
           player.resetCoords();
           player.showPath(false,fr);
           player.setTimesWon(0);
           gs.change();
           fr.getTimesWon().setText("You won 0 times");
        }
        player.moveByWalls(gs,e.getActionCommand(),fr);




    }




}
