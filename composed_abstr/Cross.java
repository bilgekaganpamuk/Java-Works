package chap_02.composed_abstr;

import java.awt.*;

public class Cross extends Shape {
    private PointG center;
    private int lengthX;
    private int lengthY;
    
    public Cross(Color color, PointG point, int x, int y) {
        super(color);
        center = new PointG(point); //center = point;
        lengthX = x;
        lengthY = y;
    }
    public Cross(Cross cross) {
        super(cross.getCenter().getColor());
        center = new PointG(cross.getCenter());
        lengthX = cross.getLengthX();
        lengthY = cross.getLengthY();
    }
    public PointG getCenter() {
        return center;
    }
    public int getLengthX() {
        return lengthX;
    }
    public int getLengthY() {
        return lengthY;
    }
    public String toString() {
        return String.format("Cross center: %s lentthX: %d lengthY: %d",
                   getCenter(), getLengthX(), getLengthY());
    }
    public void print() {
        System.out.println(this.toString());
    }
    public void draw() {
        //horizontal axis
        for(int i = 0; i < getLengthX() * 2 + 1; i++) {
            getCenter().draw( -getLengthX() + i, 0);
            PointG.delay(2);
        }
        //vertical axis
        for(int i = 0; i < getLengthY() * 2 + 1; i++) {
            getCenter().draw( 0, - getLengthY() + i);
            PointG.delay(2);
        }
    }
    public void erase() {
        //horizontal axis
        for(int i = 0; i < getLengthX() * 2 + 1; i++) {
            getCenter().erase( -getLengthX() + i, 0);
            PointG.delay(2);
        }
        //vertical axis
        for(int i = 0; i < getLengthY() * 2 + 1; i++) {
            getCenter().erase( 0, - getLengthY() + i);
            PointG.delay(2);
        }
    }
    public void move(int dx, int dy) {
        this.erase();
        moveCross(dx, dy);
        this.draw();
    }
    public void moveCross(int dx, int dy) {
        getCenter().move(dx, dy);
    }
}









