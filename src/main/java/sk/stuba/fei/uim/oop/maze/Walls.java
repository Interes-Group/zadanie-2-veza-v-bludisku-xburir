package sk.stuba.fei.uim.oop.maze;

public class Walls {
    private boolean top;
    private boolean bottom;
    private boolean right;
    private boolean left;

    public Walls(){
        top = true;
        bottom = true;
        right = true;
        left = true;
    }

    public void setWall(boolean bool,String dir){
        if (dir.equals("top")){
            this.top = bool;
        }
        if (dir.equals("bottom")){
            this.bottom = bool;
        }
        if (dir.equals("right")){
            this.right = bool;
        }
        if (dir.equals("left")){
            this.left = bool;
        }
    }

    public boolean getWall(String dir){
        if(dir.equals("top")){
            return top;
        }
        if(dir.equals("bottom")){
            return bottom;
        }
        if(dir.equals("right")){
            return right;
        }
        if(dir.equals("left")){
            return left;
        }
        return false;
    }


}
