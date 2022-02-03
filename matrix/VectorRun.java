package chap_02.matrix;

public class VectorRun {

    public static void main(String[] args) {
        Vector vektor = new Vector(6);
        vektor.print();
        vektor.setElement(0, 12);
        vektor.setElement(3, -44);
        vektor.setElement(5, 55);
        vektor.print();

    }

}
