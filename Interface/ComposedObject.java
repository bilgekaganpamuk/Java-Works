package chap_02.Interface;

import java.awt.*;

public class ComposedObject {
    private IShape[] array = new IShape[3];

    public ComposedObject() {
        array[0] = new Rectangle(new PointG(100, 100, Color.blue), new PointG(200, 200, "Modra"));
        array[1] = new Cross(Color.green, new PointG(120, 120, Color.green), 20,20);
        array[2] = new Cross(Color.green,new PointG(189,180,Color.red),10,20);
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
            array[i].erase();
        }
        for (int i = 0; i < array.length; i++) {
            array[i].move(dx, dy);
        }
        for (int i = 0; i < array.length; i++) {
            array[i].draw();
        }
    }
}
