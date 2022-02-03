package chap_02.matrix;

import javax.swing.*;

public class Matrix {
    private Vector[] rowArray;

    // konstruktor
    public Matrix(int row, int column) {
        rowArray = new Vector[row];
        for (int i = 0; i < row; i++)
            rowArray[i] = new Vector(column);
    }

    public int getNumberOfColumns() {
        return getVector(0).getNumberOfElements();
    }

    public int getNumberOfRows() {
        return rowArray.length;
    }

    // pristupova metoda
    public int getElement(int rd, int sl) {
        return getVector(rd).getElement(sl);  //r[rd].get(sl);
    }

    // modifikacni metoda
    public void setElement(int rad, int slp, int h) {
        getVector(rad).setElement(slp, h);  //r[rad].set(slp, h);
    }

    // pomocna metoda
    public Vector getVector(int number) {
        return rowArray[number];
    }

    public String toString() {
        String str = "Matrix print:\n";
        for (int i = 0; i < getNumberOfRows(); i++)
            str += getVector(i).toString() + "\n";
        return str;
    }

    public void print() {
        System.out.println(toString());
    }

    public void filling() {
        for (int i = 0; i < getNumberOfRows(); i++)
            for (int j = 0; j < getNumberOfColumns(); j++)
                setElement(i, j, enterMatrixElement(i, j));

    }

    public int enterMatrixElement(int i, int j) {
        String odp = JOptionPane.showInputDialog("" + (i + 1) +
                ", " + (j + 1) + " : ");
        return Integer.parseInt(odp);
    }

    public Matrix matrixAddition(Matrix matrix) {
        // checking
        if (getNumberOfRows() != matrix.getNumberOfRows() &&
                getNumberOfColumns() != matrix.getNumberOfColumns()) {
            System.out.println("Number of rows or columns differ ");
            return null;
        }
        // matrix addition
        Matrix matrixAdd = new Matrix(getNumberOfRows(),
                getNumberOfColumns());
        for (int i = 0; i < getNumberOfRows(); i++)
            for (int j = 0; j < getNumberOfColumns(); j++)
                matrixAdd.setElement(i, j, getElement(i, j) +
                        matrix.getElement(i, j));
        return matrixAdd;
    }

    public Matrix matrixProduct(Matrix matrix) {
        // checking
        if (getNumberOfRows() != matrix.getNumberOfColumns()) {
            System.out.println("Number of rows: " + getNumberOfRows() +
                    " number of columns: " + matrix.getNumberOfColumns());
            return null;
        }
        // matrix product
        Matrix matrixResult = new Matrix(getNumberOfRows(),
                getNumberOfRows());
        int element;
        for (int i = 0; i < getNumberOfRows(); i++) {
            for (int k = 0; k < getNumberOfRows(); k++) {
                element = 0;
                for (int j = 0; j < getNumberOfColumns(); j++)
                    element += getElement(i, j) * matrix.getElement(j, k);
                matrixResult.setElement(i, k, element);
            }
        }
        return matrixResult;
    }

}
