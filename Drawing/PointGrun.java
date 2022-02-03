package chap_02.Drawing;

public class PointGrun {
    public static void main(String[] args) {
        PointG point = new PointG(100, 200, java.awt.Color.red);
        point.draw();
        point.move(0, 1);
        point.draw();
        point.move(0, 1);
        point.draw();
        PointG pointA = new PointG(200, 300, java.awt.Color.blue);
        pointA.draw();
        pointA.move(1, 1);
        pointA.draw();
        pointA.move(1, 1);
        pointA.draw();
        pointA.move(10, 10);
        for (int i = 0; i < 100; i++) {
            point.draw(i, i);
            PointG.delay(20);
        }

    }
}

