package chap_02.Drawing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Třída vytváří kreslící plochu se základními metodami pro práci s pixelem
 *
 */
@SuppressWarnings("serial")
public class BaseCanvas extends Canvas {
    private BufferedImage bufImg, bufImgEmpty;

    /**
     * Inicializuje kreslící plochu
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     */
    public BaseCanvas(int x, int y) {
        super();
        setSize(x, y);
        //Optimalizace pro vymazani plochy
        bufImgEmpty = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        for (int coordinateY = 0; coordinateY < getHeight(); coordinateY++)
            for (int coordinateX = 0; coordinateX < getWidth(); coordinateX++)
                bufImgEmpty.setRGB(coordinateX, coordinateY, Color.white.getRGB());
        bufImg = bufImgEmpty;
    }

    /**
     * Vloží černý pixel na zadané souřadnice
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     */
    public void putPixel(int x, int y) {
        putPixel(x, y, Color.black);
    }

    /**
     * Vloží pixel na zadané souřadnice
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @param intensity - intenzita pixelu <0, 255>, 0 je černá
     */
    public void putPixel(int x, int y, int intensity) {
        putPixelNoDraw(x, y, intensity);
        repaint();
    }

    /**
     * Kontrola, zdali pixel může být umístěn na ploše
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @return
     */
    private boolean exist(int x, int y) {
        if (x >= getWidth() || x < 0 || y >= getHeight() || y < 0)
            return false;
        return true;
    }

    /**
     * Umístí barevný pixel na zadané souřadnice bez vykreslení
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @param color - Třída definující barvu pixelu
     */
    public void putPixelNoDraw(int x, int y, Color color) {
        if (!exist(x, y))
            return;
        bufImg.setRGB(x, y, color.getRGB());
    }

    /**
     * Umístí barevný pixel na zadané souřadnice bez vykreslení
     *
     * @param point - Souřadnice pixelu
     * @param color - Třída definující barvu pixelu
     */
    public void putPixelNoDraw(Point point, Color color) {
        putPixelNoDraw(point.x, point.y, color);
    }

    /**
     * Vloží pixel na zadané souřadnice bez vykreslení
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @param intensity - intenzita pixelu <0, 255>, 0 je černá
     */
    public void putPixelNoDraw(int x, int y, int intensity) {
        if (intensity > 255) intensity = 255;
        if (intensity < 0) intensity = 0;
        putPixelNoDraw(x, y, new Color(intensity, intensity, intensity));
    }

    /**
     * Vloží pixel na zadané souřadnice bez vykreslení
     *
     * @param point - souřadnice bodu
     * @param intensity - intenzita pixelu <0, 255>, 0 je černá
     */
    public void putPixelNoDraw(Point point, int intensity) {
        putPixelNoDraw(point.x, point.y, intensity);
    }

    /**
     * Vloží barevný pixel na zadané souřadnice
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @param color - Třída definující barvu pixelu
     */
    public void putPixel(int x, int y, Color color) {
        putPixelNoDraw(x, y, color);
        repaint();
    }

    /**
     * Vloží barevný pixel na zadané souřadnice
     *
     * @param point - Souřadnice pixelu
     * @param color - Třída definující barvu pixelů
     */
    public void putPixel(Point point, Color color) {
        putPixel(point.x, point.y, color);
    }

    /**
     * Vykreslí pole pixelů zadanou barvou
     *
     * @param points - Pole pixelů
     * @param color - Třída definující barvu pixelů
     */
    public void putMultiplePixels(ArrayList<Point> points, Color color)
    {
        for (Point point : points)
            putPixelNoDraw(point, color);
        draw();
    }

    /**
     * Vykreslí pole křížků zadanou barvou
     *
     * @param points - Pole křížků
     * @param color - Třída definující barvu pixelů
     */
    public void putMultipleCross(ArrayList<Point> points, Color color)
    {
        for (Point point : points)
            putCrossNoDraw(point, color);
        draw();
    }

    /**
     * Vykreslí buffer na obrazovku
     */
    public void draw() {
        repaint();
    }

    /**
     * Vymaže plochu
     */
    public void clear() {
        this.getGraphics().clearRect(0, 0, getWidth(), getHeight());
        bufImg = bufImgEmpty;
    }

    /**
     * Přetížená metoda třídy Canvas
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {
        bufImg.flush();
        g.drawImage(bufImg, 0, 0, this);
    }

    /**
     * Vrátí barvu pixelu na zadaných souřadnicích
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @return Třída definující barvu pixelu
     */
    public Color getPixel(int x, int y) {
        if (!exist(x, y))
            return null;
        return new Color(bufImg.getRGB(x, y));
    }

    /**
     * Vrátí intenzitu pixelu na zadaných souřadnicích
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @return Intenzita pixelu
     */
    public int getPixelIntensity(int x, int y) {
        Color color = getPixel(x, y);
        return (int) ((0.2126 * color.getRed()) + (0.7152 * color.getGreen()) + (0.0722 * color.getBlue()));
    }

    /**
     * Vloží křížek na dané souřadnice
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @param color - Třída definující barvu křížku
     */
    public void putCross(int x, int y, Color color) {
        putCrossNoDraw(x, y, color);
        repaint();
    }

    /**
     * Vloží křížek na dané souřadnice
     *
     * @param point - Souřadnice křížku
     * @param color - Třída definující barvu křížku
     */
    public void putCross(Point point, Color color) {
        putCross(point.x, point.y, color);
    }

    /**
     * Vloží křížek do bufferu na dané souřadnice
     *
     * @param x - souřadnice X
     * @param y - souřadnice Y
     * @param color - Třída definující barvu křížku
     */
    public void putCrossNoDraw(int x, int y, Color color) {
        for (int coordinateY = y - 2; coordinateY < y + 3; coordinateY++)
            if (exist(x, coordinateY))
                putPixelNoDraw(x, coordinateY, color);
        for (int coordinateX = x - 2; coordinateX < x + 3; coordinateX++)
            if (exist(coordinateX, y))
                putPixelNoDraw(coordinateX, y, color);
    }

    /**
     * Vloží křížek do bufferu na dané souřadnice
     *
     * @param point - Souřadnice křížku
     * @param color - Třída definující barvu křížku
     */
    public void putCrossNoDraw(Point point, Color color) {
        putCrossNoDraw(point.x, point.y, color);
    }

    /**
     * Otevře obrázek
     *
     * @param file - soubor s obrázkem
     */
    public void loadPicture(File file)
    {
        if (file.getPath().toLowerCase().endsWith(".sbm"))
        {
            loadSBM(file);
            return;
        }
        clear();
        try{
            bufImg = ImageIO.read(file);
            this.setSize(bufImg.getWidth(), bufImg.getHeight());
            draw();
        }catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Při otevírání souboru nastala chyba: " +
                    e.getLocalizedMessage(), "Chyba", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Otevře soubor SBM
     *
     * @param file - soubor SBM
     */
    private void loadSBM(File file) {
        try {
            clear();
            java.util.Scanner scanner = new java.util.Scanner(new java.io.FileReader(file));
            int coordinateX = scanner.nextInt();
            int coordinateY = scanner.nextInt();
            this.setSize(coordinateX, coordinateY);
            for (int y = 0; y < coordinateY; y++)
                for (int x = 0; x < coordinateX; x++)
                    putPixelNoDraw(x, y, scanner.nextInt());
            repaint();
            scanner.close();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Při otevírání souboru nastala chyba: "+e.getLocalizedMessage(),
                    "Chyba", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }


}
