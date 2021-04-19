package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private Layout layout;
    private final int CELL_SIZE;
    private final int SIZE;
    private Player player;

    public GameScreen(int SIZE,int CELL_SIZE,Player player){
        this.layout = new Layout(SIZE);
        this.CELL_SIZE = CELL_SIZE;
        this.SIZE = SIZE;
        this.player = player;



    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(5,20,layout.getGrid().length* CELL_SIZE,layout.getGrid().length* CELL_SIZE);

        g.setColor(Color.RED);
        g.fillOval(5 + layout.getEndpoint().getX()*  CELL_SIZE, 20+layout.getEndpoint().getY()*CELL_SIZE,CELL_SIZE,CELL_SIZE);


        g.setColor(Color.BLACK);

        for (int r = 0;r < layout.getGrid().length;r++){
            for (int c= 0 ; c< layout.getGrid().length;c++) {
                if (layout.getCell(c, r).getWalls().getWall("top")){
                    g.drawLine(r * CELL_SIZE + 5, c * CELL_SIZE + 20, r * CELL_SIZE + 5 + CELL_SIZE, c * CELL_SIZE + 20);   //top line
                }
                if (layout.getCell(c, r).getWalls().getWall("bottom")){
                    g.drawLine(r * CELL_SIZE + 5, c * CELL_SIZE + 20 + CELL_SIZE, r * CELL_SIZE + 5 + CELL_SIZE, c * CELL_SIZE + 20 + CELL_SIZE);   //bottom line
                }
                if (layout.getCell(c, r).getWalls().getWall("left")){
                    g.drawLine(r * CELL_SIZE + 5, c * CELL_SIZE + 20, r * CELL_SIZE + 5, c * CELL_SIZE + 20 + CELL_SIZE);   //left line
                }
                if (layout.getCell(c, r).getWalls().getWall("right")){
                    g.drawLine(r * CELL_SIZE + 5 + CELL_SIZE, c * CELL_SIZE + 20, r * CELL_SIZE + 5 + CELL_SIZE, c * CELL_SIZE + 20 + CELL_SIZE);   //right line
                }

            }
        }

        g.setColor(Color.GREEN);
        g.fillOval(5 + player.getX()*  CELL_SIZE, 20+player.getY()*CELL_SIZE,CELL_SIZE,CELL_SIZE);


    }

    public Layout getLay(){
        return this.layout;
    }


    public void change(){
        this.layout = new Layout(SIZE);
        repaint();
    }

}
