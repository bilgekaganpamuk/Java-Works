package chap_02.InterfaceAL;

import chap_02.Drawing.ComposedObject;
import chap_02.Drawing.PointG;

public class ComposedObjectRun {
        public static void main(String[] args) {
            int dx = 150;
            int dy = 120;

            ComposedObject composedObject = new ComposedObject();
            composedObject.draw();
            PointG.delay(2);
            for(int i=0;i<3;i=i+1) {
                composedObject.moveComposedObject(dx+i, dy);
            }
        }
    }
