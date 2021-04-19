package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private Cell[][] grid;
    private Layout layout;
    private final int CELL_SIZE = 15;
    public GameScreen(Layout layout){
        this.grid = layout.getGrid();
        this.layout = layout;
        repaint();

    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(5,20,grid.length* CELL_SIZE,grid.length* CELL_SIZE);
        g.setColor(Color.BLACK);

        for (int r = 0;r < grid.length;r++){
            for (int c= 0 ; c< grid[r].length;c++) {
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

    }

}
