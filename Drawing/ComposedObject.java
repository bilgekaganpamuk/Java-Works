package chap_02.Drawing;

import chap_02.Abstract.Shape;

import java.awt.*;

public class ComposedObject {
    private Rectangle rec;
    private Cross crs;
    private Shape[] array = new Shape[3];

    public ComposedObject(Rectangle rec, Cross crs) {

        this.rec = new Rectangle(rec);
        this.crs = new Cross(crs);
    }

    public ComposedObject() {
        array[0] = new Rectangle(Color.red, new PointG(100, 100, Color.blue), new PointG(200, 200, ",Modra"));
        array[1] = new Cross(Color.green, new PointG(120, 150, Color.green), 20, 40);
        array[2] = new Cross(Color.pink, new PointG(189, 180, Color.red), 10, 20);
    }

    public Rectangle getRec() {
        return rec;
    }

    public void setCrs(Cross crs) {
        this.crs = crs;
    }

    public Cross getCrs() {
        return crs;
    }

    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    public void draw() {
        for (int i = 0; i < array.length; i++) {
            array[i].draw();
        }
    }

    public void erase() {
        for (int i = 0; i < array.length; i++) {
            array[i].erase();
        }
    }

    public void move(int dx, int dy) {
        for (int i = 0; i < array.length; i++) {
            array[i].move(dx, dy);
        }
    }

    @Override
    public String toString() {
        return "ComposedObject{" +
                "rec=" + rec +
                ", crs=" + crs +
                '}';
    }

    public void moveComposedObject(int dx, int dy) {
        erase();
        move(dx, dy);
        PointG.delay(1);
        draw();

    }
}
