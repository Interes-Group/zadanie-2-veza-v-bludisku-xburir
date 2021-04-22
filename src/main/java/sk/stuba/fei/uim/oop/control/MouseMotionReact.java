package sk.stuba.fei.uim.oop.control;

import sk.stuba.fei.uim.oop.frontend.Frame;
import sk.stuba.fei.uim.oop.frontend.GameScreen;
import sk.stuba.fei.uim.oop.Player;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionReact extends JPanel implements MouseMotionListener {
    private Player player;
    private GameScreen gs;
    private Frame fr;
    private int SIZE;
    private int CELL_SIZE;
    private int oldy;
    private int oldx;

    public MouseMotionReact(Player player, GameScreen gs, Frame fr,int SIZE, int CELL_SIZE){
        this.player = player;
        this.gs = gs;
        this.fr = fr;
        this.CELL_SIZE= CELL_SIZE;
        this.SIZE = SIZE;
        this.oldx = 0;
        this.oldy = 0;
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = (e.getX()-5)/CELL_SIZE;
        int y = (e.getY()-20)/CELL_SIZE;
        if (oldx != x || oldy != y){
            this.oldx = x;
            this.oldy = y;
            gs.setMouseOnY(y);
            gs.setMouseOnX(x);
            fr.repaint();

        }

    }
}
