package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private GameScreen gs;
    private ButtonsScreen buttons;
    private JLabel timesWon;
    private final int SIZE;
    private final int CELL_SIZE;


    public Frame(int SIZE,int CELL_SIZE,Player player){
        this.SIZE = SIZE;
        this.CELL_SIZE = CELL_SIZE;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(30+CELL_SIZE*SIZE,130+CELL_SIZE*SIZE);
        setTitle("Richard's maze");
        setLayout(new BorderLayout());
        this.gs = new GameScreen(SIZE,CELL_SIZE,player);
        this.buttons = new ButtonsScreen(player,gs,this);
        this.addKeyListener(new KeyReact(player,gs,this));
        gs.addMouseListener(new MouseReact(player,gs,this,SIZE,CELL_SIZE));
        this.timesWon = new JLabel("You won "+ player.getTimesWon()+" times");
        add("South",timesWon);
        add("North",buttons);
        add("Center",gs);
        setResizable(false);

        setVisible(true);


    }

    public JLabel getTimesWon(){
        return timesWon;
    }

    public void won(Player player){
        player.resetCoords();
        player.setTimesWon(player.getTimesWon()+1);
        timesWon.setText("You won "+player.getTimesWon()+" times");
        gs.change();
    }

}
