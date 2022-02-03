package chap_02.ComposedArraylistInterface;

import chap_02.Interface.PointG;
import chap_02.Interface.Cross;
import chap_02.Interface.IShape;
import chap_02.Interface.Rectangle;
import java.awt.*;

public class ComposedObjectRun {
    public static void main(String[] args) {
        ComposedObject compoundObject = new ComposedObject();
        compoundObject.addShape(new Cross(Color.green,new PointG(100, 200, Color.blue), 20, 30));
        Rectangle rectangle = new Rectangle(new PointG(130, 220, Color.green),
                new PointG(180, 310, Color.green));
        compoundObject.addShape(rectangle);
        rectangle = new Rectangle(new PointG(160, 280, Color.red),
                new PointG(210, 340, Color.red));
        compoundObject.addShape(rectangle);
        compoundObject.draw();
        compoundObject.move(70, 90);

        // auxiliary operations
        IShape shape = (IShape) compoundObject.getList().get(1);
        String string = shape.toString();
        System.out.println("String output: " + string);


    }
}
