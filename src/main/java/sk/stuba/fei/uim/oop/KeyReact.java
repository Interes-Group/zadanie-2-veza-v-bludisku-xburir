package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyReact extends JPanel implements KeyListener {
    private Player player;
    private GameScreen gs;
    private Frame fr;

    public KeyReact(Player player, GameScreen gs, Frame fr){
        this.player = player;
        this.gs = gs;
        this.fr = fr;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            player.moveByWalls(gs,"Right",fr);
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            player.moveByWalls(gs,"Left",fr);
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            player.moveByWalls(gs,"Down",fr);
        }
        if(e.getKeyCode()== KeyEvent.VK_UP){
            player.moveByWalls(gs,"Up",fr);
        }

    }

    public void keyReleased(KeyEvent e){





    }


}
