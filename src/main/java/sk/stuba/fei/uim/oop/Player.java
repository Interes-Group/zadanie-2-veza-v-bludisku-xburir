package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Player {
    private int x;
    private int y;
    private int timesWon;
    private boolean pathShowed;
    private ArrayList<Cell> cellsReachable;

    public Player(){
        resetCoords();
        this.pathShowed = false;
        this.cellsReachable = new ArrayList<>();



    }

    public void showPath(Boolean ans,Frame fr){
        this.pathShowed = ans;


    }

    public boolean isCellReachableByPlayer(int mouseOnX,int mouseOnY){

        for (var cell : cellsReachable){
            if (cell.getY() == mouseOnY && cell.getX() == mouseOnX){
                return true;
            }
        }
        return false;


    }

    public void setCellsReachable(Layout layout){
        while(!cellsReachable.isEmpty()){
            this.cellsReachable.remove(0);
        }
        int py = getY(); int px = getX();
        while(!layout.getCell(py,px).getWalls().getWall("right")){
            px++;
            this.cellsReachable.add(layout.getCell(py,px));
        }
        py = getY(); px =getX();
        while(!layout.getCell(py,px).getWalls().getWall("left")){
            px--;
            this.cellsReachable.add(layout.getCell(py,px));
        }
        py = getY(); px = getX();
        while(!layout.getCell(py,px).getWalls().getWall("bottom")){
            py++;
            this.cellsReachable.add(layout.getCell(py,px));
        }

        py = getY(); px =getX();
        while(!layout.getCell(py,px).getWalls().getWall("top")){
            py--;
            this.cellsReachable.add(layout.getCell(py,px));
        }
    }

    public ArrayList<Cell> getCellsReachable(){
        return cellsReachable;
    }





    public boolean isPathShowed(){
        return pathShowed;
    }

    public void setTimesWon(int number){
        this.timesWon = number;
    }

    public void resetCoords(){
        this.x = 0;
        this.y = 0;
    }

    public int getTimesWon(){
        return timesWon;
    }

    public int getY(){
        return y;
    }

    public int getX() {
        return x;
    }


    public void move(int x, int y){
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public void moveByWalls(GameScreen gs,String dir,Frame fr){


        if(dir.equals("Right")){
            if(!gs.getLay().getCell(getY(), getX()).getWalls().getWall("right")){
                move(1,0);
            }
        }
        if(dir.equals("Left")){
            if(!gs.getLay().getCell(getY(), getX()).getWalls().getWall("left")){
                move(-1,0);
            }
        }
        if(dir.equals("Down")){
            if(!gs.getLay().getCell(getY(), getX()).getWalls().getWall("bottom")){
                move(0,1);
            }
        }
        if(dir.equals("Up")){
            if(!gs.getLay().getCell(getY(), getX()).getWalls().getWall("top")){
                move(0,-1);
            }
        }

        if(getX() == gs.getLay().getEndpoint().getX() && getY() == gs.getLay().getEndpoint().getY()){
            fr.won(this);
        }
        setCellsReachable(gs.getLay());
        fr.repaint();

    }

}
