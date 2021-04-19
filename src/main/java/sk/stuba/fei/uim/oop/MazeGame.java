package sk.stuba.fei.uim.oop;

public class MazeGame {
    private final int SIZE = 50;
    private Frame window;
    private Layout layout;

    public MazeGame(){
        this.layout = new Layout(SIZE);
        this.window = new Frame(layout);


    }




}
