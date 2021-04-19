package sk.stuba.fei.uim.oop;

public class MazeGame {
    private final int SIZE = 15;
    private final int CELL_SIZE = 30;
    private Frame window;
    private Player player;

    public MazeGame(){
        this.player = new Player();
        this.window = new Frame(SIZE,CELL_SIZE,player);


    }




}
