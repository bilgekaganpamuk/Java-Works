package chap_02.composed_abstr;

import chap_02.Drawing.ComposedObject;
import chap_02.Drawing.PointG;

public class ComposedObjectRun {
    public static void main(String[] args) {
        ComposedObject composedObject = new ComposedObject();
        composedObject.draw();
        PointG.delay(2);
        composedObject.moveComposedObject(150,120);
    }
}
