package chap_02.Drawing;

import java.awt.Color;
import java.util.Objects;

import java.awt.Color;
public class PointG {
    private int x;
    private int y;
    private Color color;
    private BaseCanvas canvas = Gui.getInstance().getCanvas();
    private Color backGroundColor = Color.white;

    public PointG() {
        //x = 0; y = 0;
        this(0, 0, Color.red);
    }
    public PointG(int x, int y, Color color ) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public PointG(int x, int y, String color1) {
        this.x = x;
        this.y = y;
        this.setColor(this.stringToColor(color1));
    }
    // copy constructor
    public PointG(PointG point) {
        this.setX(point.getX());
        y = point.getY();
        setColor(point.getColor());
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
    public BaseCanvas getCanvas() {
        return canvas;
    }
    public Color getBackGroundColor() {
        return backGroundColor;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public String toString() {
        return "Bod x: " + getX() + " y: " + getY() + " color: " + getColor();
    }
    public void print() {
        System.out.println(this.toString());
    }
    public void move(int dx, int dy) {
        setX(getX() + dx);
        this.setY(getY() + dy);
    }
    public void movePoint(int dx, int dy) {
        this.erase();
        PointG.delay(100);
        this.move(dx, dy);
        this.draw();
    }
    public void draw(){
        this.getCanvas().putPixel(getX(), getY(), getColor());
    }
    public void draw(int dx,int dy) {
        this.getCanvas().putPixel(getX() + dx, getY() + dy, getColor());
    }
    public void erase(){
        this.getCanvas().putPixel(getX(), getY(), getBackGroundColor());
    }
    public void erase(int dx, int dy) {
        this.getCanvas().putPixel(getX() + dx, getY() + dy, getBackGroundColor());
    }
    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException e) {
            System.out.println("Error in delay method");
        }
    }
    public Color stringToColor(String color1) {
        switch(color1) {
            case "cervena": return Color.red;
            case "cerna": return Color.black;
            case "modra": return Color.blue;
            case "zelena": return Color.green;
            default: return Color.red;
        }
    }
}






