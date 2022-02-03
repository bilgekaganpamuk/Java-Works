package chap_02.Interface;

import chap_02.Drawing.ComposedObject;
import chap_02.Drawing.PointG;

public class ComposedObjectRun {
    public static void main(String[] args) {
        chap_02.Drawing.ComposedObject composedObject = new ComposedObject();
        composedObject.draw();
        PointG.delay(2);
        composedObject.moveComposedObject(150,120);
    }
}
