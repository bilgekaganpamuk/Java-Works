package chap_02.composed_abstr;

import java.awt.*;

public abstract class Shape {
    private Color color;
    private int delay = 1;
    public Shape(Color color) {
        this.color = color;
    }
    public Shape(String color) {
        this.color = stringToColor(color);
    }

    public Color getColor() {
        return color;
    }

    public int getDelay() {
        return delay;
    }

    public void setColor(Color color) {
        this.color = color;
    }
 //Abstract methods
    public abstract void draw();

    public abstract void erase();

    public abstract void move(int dx, int dy);

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return "color: " + getColor();
    }

    public Color stringToColor(String color1) {
        switch (color1) {
            case "cervena":
                return Color.red;
            case "cerna":
                return Color.black;
            case "modra":
                return Color.blue;
            case "zelena":
                return Color.green;
            default:
                return Color.red;
        }
   }

}













