package chap_02.matrix;

public class Vector {
    private int[] columnArray;

    public Vector(int columns) {
        columnArray = new int[columns];
        //elementNumber = columns;
    }

    public int getElement(int i) {
        if ((i >= 0) && (i < columnArray.length))
            return columnArray[i];
        else return 0;
    }

    public void setElement(int i, int h) {
        if ((i >= 0) && (i < getNumberOfElements()))
            columnArray[i] = h;
        else System.out.println("Enter vector error");
    }

    public int[] getVector() {
        return columnArray;
    }

    public void setVector(int[] newVector) {
        columnArray = newVector;
    }

    /*
    public String toString() {
        String string = "";
        for(int i = 0; i < getNumberOfElements(); i++)
            retez += columnArray[i] + " ";
        return retez;
    } */
    public String toString() {
        StringBuffer sBuf = new StringBuffer("");
        for (int i = 0; i < getNumberOfElements(); i++) {
            sBuf.append(getElement(i));
            sBuf.append(' ');
        }
        return sBuf.toString();
    }

    public void print() {
        System.out.println(toString());
    }

    public int getNumberOfElements() {
        return columnArray.length;
    }

}
