package chap_02.Interface;

import java.awt.Color;
public class Rectangle implements IShape{
    private PointG upperLeft;
    private PointG lowerRight;
    public Rectangle(PointG left, PointG right) {
        //super(barva);
        //left.setColor(this.getColor());
        //right.setColor(getColor());
        upperLeft = new PointG(left);
        lowerRight = new PointG(right);
    }
    // kopirovaci konstruktor
    public Rectangle(Rectangle rc) {
        //super(ob.getUpperLeft().getBarva());
        upperLeft = new PointG(rc.getUpperLeft());
        lowerRight = new PointG(rc.getLowerRight());
    }
    public PointG getUpperLeft() {
        return upperLeft;
    }
    public PointG getLowerRight() {
        return lowerRight;
    }
    public void setUpperLeft(PointG point) {
        upperLeft = new PointG(point); // levyHorni = bod; 
    }
    public void setLowerRight(PointG point) {
        lowerRight = new PointG(point);
    }
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        sb.append("Rectangle:\n"); //(this.getClass.getName() + ":\n")
        sb.append(getUpperLeft().toString());
        sb.append("\n");
        sb.append(getLowerRight().toString());
        return sb.toString();
    }
    public void print() {
        System.out.println(toString());
    }
    public int lengthX() {
        return getLowerRight().getX() - getUpperLeft().getX();        
    }
    public int lengthY() {
        return getLowerRight().getY() - getUpperLeft().getY();
    }
    public void draw() {
        // vodorovne strany
        for(int i = 0; i < lengthX(); i++){
            getUpperLeft().draw(i, 0);
            getLowerRight().draw(-i, 0);
            PointG.delay(20);
        }
                //svisle strany
        for(int i = 0; i < lengthY(); i++) {
            getUpperLeft().draw(0, i);
            getLowerRight().draw(0, -i);
            PointG.delay(20);
        }
    }
    public void erase() {
        // vodorovne strany
        for(int i = 0; i < lengthX(); i++){
            getUpperLeft().erase(i, 0);
            getLowerRight().erase(-i, 0);
            PointG.delay(20);
        }
                //svisle strany
        for(int i = 0; i < lengthY(); i++) {
            getUpperLeft().erase(0, i);
            getLowerRight().erase(0, -i);
            PointG.delay(20);
        }
    }

    public void moveRectangle(int dx, int dy) {
        getUpperLeft().move(dx, dy);
        getLowerRight().move(dx, dy);
    }

    public void move(int dx, int dy) {
        erase();
        moveRectangle(dx, dy);
        draw();        
    }
}















