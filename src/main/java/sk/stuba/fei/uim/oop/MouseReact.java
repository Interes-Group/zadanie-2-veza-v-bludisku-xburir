package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseReact extends JPanel implements MouseListener {
    private Player player;
    private GameScreen gs;
    private Frame fr;
    private int SIZE;
    private int CELL_SIZE;

    public MouseReact(Player player, GameScreen gs, Frame fr,int SIZE, int CELL_SIZE){
        this.player = player;
        this.gs = gs;
        this.fr = fr;
        this.CELL_SIZE= CELL_SIZE;
        this.SIZE = SIZE;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (e.getX()-5)/CELL_SIZE;
        int y = (e.getY()-20)/CELL_SIZE;
        if (x < SIZE || y < SIZE){
            if(x==player.getX() && y == player.getY()){
                player.showPath(!player.isPathShowed(),fr);
            }
        }
        if(player.isPathShowed()){
            boolean change = false;
            for(var cell : player.getCellsReachable()){
                if(cell.getY() == y && cell.getX() == x){
                    change = true;
                    break;
                }
            }
            if (change){
                int difx = x-player.getX();
                int dify = y-player.getY();
                if (difx > 0){
                    for(int i = 0;i<difx;i++){
                        player.moveByWalls(gs,"Right",fr);
                    }
                }
                if (difx < 0){
                    difx = difx*(-1);
                    for(int i = 0;i<difx;i++){
                        player.moveByWalls(gs,"Left",fr);
                    }
                }
                if (dify > 0){
                    for(int i = 0;i<dify;i++){
                        player.moveByWalls(gs,"Down",fr);
                    }
                }
                if (dify < 0){
                    dify = dify*(-1);
                    for(int i = 0;i<dify;i++){
                        player.moveByWalls(gs,"Up",fr);
                    }
                }
            }
        }



        fr.repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
