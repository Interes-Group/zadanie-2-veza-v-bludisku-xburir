package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;
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

        checks(grid);

    }

    private void checks(Cell[][] grid){
        for (int r = 0;r< grid.length;r++){
            for (int c = 0; c<grid[r].length;c++){
                if(grid[r][c].getWalls().getWall("right") == true &&  grid[r][(c+1)%grid.length].getWalls().getWall("left") == false){
                    System.out.println("prvok "+r+" "+c+" ma pravu a prvok "+ r+" "+c+1+" nema spodnu");
                }
                if(grid[r][c].getWalls().getWall("top") == true &&  grid[(r+1)%grid.length][c].getWalls().getWall("bottom") == false){
                    System.out.println("prvok "+r+" "+c+" ma vrchnu a prvok "+ (r+1) +" "+c+" nema spodnu");
                }
            }
        }
    }

    private Cell getRandomUnvisitedNeighbor(Cell current,Random rand){
        int size = current.getNeighbours().size();
        int number = rand.nextInt(size);
        Cell chosenNeighbor = current.getNeighbours().get(number);

        ArrayList<Integer> usedInts = new ArrayList<>();

        while(chosenNeighbor.isVisited()){
            number = rand.nextInt(size);
            chosenNeighbor = current.getNeighbours().get(number);
            if (!usedInts.contains(number)){
                usedInts.add(number);
            }
            if(usedInts.size()==size){
                return null;
            }
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
