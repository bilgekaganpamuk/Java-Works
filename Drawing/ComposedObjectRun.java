package chap_02.Drawing;

import java.awt.*;

public class ComposedObjectRun {
    public static void main(String[] args) {
        ComposedObject composedObject = new ComposedObject();
        composedObject.draw();
        PointG.delay(2);
        composedObject.moveComposedObject(150,120);
    }
}
