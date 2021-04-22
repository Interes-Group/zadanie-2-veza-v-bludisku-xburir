package sk.stuba.fei.uim.oop.maze;

import java.util.ArrayList;

public class Cell {
    private boolean visited;
    private int x;
    private int y;
    private ArrayList<Cell> neighbours;
    private Walls walls;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        neighbours = new ArrayList<>();
        this.visited = false;
        this.walls = new Walls();

    }

    public Walls getWalls() {
        return walls;
    }

    public boolean isVisited(){
        return visited;
    }

    public void markVisited(){
        this.visited = true;
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setNeighbours(Cell[][] grid){
        if(y >=1 ){
            neighbours.add(grid[y-1][x]);
        }
        if(x >= 1){
            neighbours.add(grid[y][x-1]);
        }
        if(x < grid.length-1){
            neighbours.add(grid[y][x+1]);
        }
        if(y < grid.length-1){
            neighbours.add(grid[y+1][x]);
        }
    }

    public ArrayList<Cell> getNeighbours() {
        return neighbours;
    }
}
