package chap_02.ComposedArraylistInterface;

import chap_02.Interface.Cross;
import chap_02.Interface.IShape;
import chap_02.Interface.PointG;
import chap_02.Interface.Rectangle;

import java.awt.*;
import java.util.ArrayList;

public class ComposedObject {

    private ArrayList<IShape> list;
    //constructor
    public ComposedObject() {
        list = new ArrayList();
    }
    //access methods
    public ArrayList getList() {
        return list;
    }
    public void addShape(IShape shape) {
        getList().add(shape);
    }
    public void draw() {
        for(int i = 0; i < list.size(); i++)
            ((IShape)getList().get(i)).draw();
    }
    public void erase() {
        for(int i = 0; i < list.size(); i++)
            ((IShape)getList().get(i)).erase();
    }
    public void move(int dx, int dy) {
        erase();
        for(int i = 0; i < list.size(); i++)
            ((IShape)getList().get(i)).move(dx, dy);
        draw();
    }




    public void example() {
        IShape shape = (IShape) getList().get(1);
        String string = shape.toString();
    }
}
