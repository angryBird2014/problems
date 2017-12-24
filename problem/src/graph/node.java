package graph;

/**
 * Created by xyan on 10/12/17.
 */
public class node {
    private int x;
    private int y;
    public node(int x,int y){
        this.x = x;
        this.y = y;
    }
    public node(){
        this.x = 0;
        this.y = 0;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
