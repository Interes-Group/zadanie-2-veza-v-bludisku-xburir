package sk.stuba.fei.uim.oop;

import java.util.Random;

public class Layout {
    private Cell[][] grid;


    public Layout(int size){
        this.grid = new Cell[size][size];
        createLayout(size);
        setNeighbors();
        generate();

    }

    private void createLayout(int size){
        for (int r = 0;r<size;r++){
            for (int c = 0; c<size;c++){
                grid[r][c] = new Cell(c,r);
            }
        }
    }

    private void generate(){
        Random rand = new Random();
        Cell start = grid[0][0];
        randomizedDFS(start,rand);

    }


    private Cell getRandomUnvisitedNeighbor(Cell current,Random rand){
        int size = current.getNeighbours().size();
        if(size<1){
            return null;
        }
        int number = rand.nextInt(size);
        Cell chosenNeighbor = current.getNeighbours().get(number);
        while(chosenNeighbor.isVisited()){
            current.getNeighbours().remove(chosenNeighbor);
            size = current.getNeighbours().size();
            if(size<1){
                return null;
            }
            number = rand.nextInt(size);
            chosenNeighbor = current.getNeighbours().get(number);
        }
        return chosenNeighbor;
    }

    private void randomizedDFS(Cell current,Random rand){
        current.markVisited();
        Cell next = getRandomUnvisitedNeighbor(current,rand);
        while (next != null){
            connectCells(current,next);
            randomizedDFS(next,rand);
            next = getRandomUnvisitedNeighbor(current,rand);
        }
    }

    private void connectCells(Cell current, Cell next){
        if(current.getX() == next.getX()){      //one under another
            if(current.getY() < next.getY()){
                current.getWalls().setWall(false,"bottom");
                next.getWalls().setWall(false,"top");
            }
            else if (current.getY() > next.getY()){
                current.getWalls().setWall(false,"top");
                next.getWalls().setWall(false,"bottom");
            }
        }
        else if(current.getY() == next.getY()){
            if(current.getX() > next.getX()){
                current.getWalls().setWall(false,"left");
                next.getWalls().setWall(false,"right");
            }
            else if(current.getX() < next.getX()){
                current.getWalls().setWall(false,"right");
                next.getWalls().setWall(false,"left");
            }
        }
    }

    private void setNeighbors(){
        for (int r = 0;r< grid.length;r++){
            for (int c = 0; c<grid[r].length;c++){
                grid[r][c].setNeighbours(grid);
            }
        }
    }


    public Cell[][] getGrid(){
        return grid;
    }

    public Cell getCell(int r, int c){
        return grid[r][c];
    }
}
