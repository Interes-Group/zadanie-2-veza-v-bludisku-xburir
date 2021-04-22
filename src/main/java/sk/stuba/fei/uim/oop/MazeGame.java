package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.frontend.Frame;

public class MazeGame {
    private final int SIZE;
    private final int CELL_SIZE;
    private Frame window;
    private Player player;

    public MazeGame(int size,int cellSize){
        this.player = new Player();
        this.SIZE = size;
        this.CELL_SIZE = cellSize;
        this.window = new Frame(SIZE,CELL_SIZE,player);


    }




}
