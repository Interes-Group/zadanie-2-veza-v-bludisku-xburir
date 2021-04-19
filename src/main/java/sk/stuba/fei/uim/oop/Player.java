package sk.stuba.fei.uim.oop;

public class Player {
    private int x;
    private int y;
    private int timesWon;

    public Player(){
        resetCoords();
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

        fr.repaint();

    }

}
