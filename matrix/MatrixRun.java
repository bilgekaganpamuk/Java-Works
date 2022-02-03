package chap_02.matrix;

public class MatrixRun {
    public static void main(String[] args) {
		/*
		Matrix m = new Matrix(4,6);
		m.print();
		m.setElement(0, 2, 123);
		m.setElement(2,0, -55);
		m.print();
		m.filling();
		m.print();
		*/
        System.out.println("Matice soucet:");
        Matrix s1 = new Matrix(2, 2);
        s1.filling();
        Matrix s2 = new Matrix(2, 2);
        s2.filling();
        System.out.println("Tisk zdrojovych matic");
        s1.print();
        s2.print();
        System.out.println("Tisk souctu zdrojovych matic");
        Matrix s3 = s1.matrixAddition(s2);
        s3.print();
        System.out.println("Soucin matic:");
        Matrix a = new Matrix(2, 3);
        a.filling();
        Matrix b = new Matrix(3, 2);
        b.filling();
        System.out.println("Tisk zdrojovych matic");
        a.print();
        b.print();
        System.out.println("Tisk soucinu zdrojovych matic");
        Matrix c = a.matrixProduct(b);
        c.print();
		/*
		Matice d = b.soucinMatic(a);
		if(d != null) d.tisk();

		 */

    }

}
