package chap_02.Abstract;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/*
 * T��da vytv��� kresl�c� plochu se z�kladn�mi metodami pro pr�ci s pixelem
 * 
 */
@SuppressWarnings("serial")
public class BaseCanvas extends Canvas {
	private BufferedImage bufImg, bufImgEmpty;

	/**
	 * Inicializuje kresl�c� plochu
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
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
	 * Vlo�� �ern� pixel na zadan� sou�adnice
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 */
	public void putPixel(int x, int y) {
		putPixel(x, y, Color.black);
	}

	/**
	 * Vlo�� pixel na zadan� sou�adnice
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @param intensity - intenzita pixelu <0, 255>, 0 je �ern�
	 */
	public void putPixel(int x, int y, int intensity) {
		putPixelNoDraw(x, y, intensity);
		repaint();
	}

	/**
	 * Kontrola, zdali pixel m��e b�t um�st�n na plo�e
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @return
	 */
	private boolean exist(int x, int y) {
		if (x >= getWidth() || x < 0 || y >= getHeight() || y < 0)
			return false;
		return true;
	}

	/**
	 * Um�st� barevn� pixel na zadan� sou�adnice bez vykreslen�
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @param color - T��da definuj�c� barvu pixelu
	 */
	public void putPixelNoDraw(int x, int y, Color color) {
		if (!exist(x, y))
			return;
		bufImg.setRGB(x, y, color.getRGB());
	}

	/**
	 * Um�st� barevn� pixel na zadan� sou�adnice bez vykreslen�
	 * 
	 * @param point - Sou�adnice pixelu
	 * @param color - T��da definuj�c� barvu pixelu
	 */
	public void putPixelNoDraw(Point point, Color color) {
		putPixelNoDraw(point.x, point.y, color);
	}
	
	/**
	 * Vlo�� pixel na zadan� sou�adnice bez vykreslen�
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @param intensity - intenzita pixelu <0, 255>, 0 je �ern�
	 */
	public void putPixelNoDraw(int x, int y, int intensity) {
		if (intensity > 255) intensity = 255;
		if (intensity < 0) intensity = 0;
		putPixelNoDraw(x, y, new Color(intensity, intensity, intensity));
	}

	
	/**
	 * Vlo�� pixel na zadan� sou�adnice bez vykreslen�
	 * 
	 * @param point - sou�adnice bodu
	 * @param intensity - intenzita pixelu <0, 255>, 0 je �ern�
	 */
	public void putPixelNoDraw(Point point, int intensity) {
		putPixelNoDraw(point.x, point.y, intensity);
	}
	
	/**
	 * Vlo�� barevn� pixel na zadan� sou�adnice
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @param color - T��da definuj�c� barvu pixelu
	 */
	public void putPixel(int x, int y, Color color) {
		putPixelNoDraw(x, y, color);
		repaint();
	}
	
	/**
	 * Vlo�� barevn� pixel na zadan� sou�adnice
	 * 
	 * @param point - Sou�adnice pixelu
	 * @param color - T��da definuj�c� barvu pixel� 
	 */
	public void putPixel(Point point, Color color) {
		putPixel(point.x, point.y, color);
	}
	
	/**
	 * Vykresl� pole pixel� zadanou barvou
	 * 
	 * @param points - Pole pixel�
	 * @param color - T��da definuj�c� barvu pixel�
	 */
	public void putMultiplePixels(ArrayList<Point> points, Color color)
    {
    	for (Point point : points)
			 putPixelNoDraw(point, color);	                           
        draw();
    }

	/**
	 * Vykresl� pole k��k� zadanou barvou
	 * 
	 * @param points - Pole k��k�
	 * @param color - T��da definuj�c� barvu pixel�
	 */
    public void putMultipleCross(ArrayList<Point> points, Color color)
    {
        for (Point point : points)
            putCrossNoDraw(point, color);
        draw();
    }
	
	/**
	 * Vykresl� buffer na obrazovku
	 */
	public void draw() {
		repaint();
	}

	/**
	 * Vyma�e plochu
	 */
	public void clear() {
		this.getGraphics().clearRect(0, 0, getWidth(), getHeight());
		bufImg = bufImgEmpty;
	}

	/**
	 * P�et�en� metoda t��dy Canvas
	 * @see Canvas#paint(Graphics)
	 */
	public void paint(Graphics g) {
		bufImg.flush();
		g.drawImage(bufImg, 0, 0, this);
	}

	

	/**
	 * Vr�t� barvu pixelu na zadan�ch sou�adnic�ch
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @return T��da definuj�c� barvu pixelu
	 */
	public Color getPixel(int x, int y) {
		if (!exist(x, y))
			return null;
		return new Color(bufImg.getRGB(x, y));
	}

	/**
	 * Vr�t� intenzitu pixelu na zadan�ch sou�adnic�ch
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @return Intenzita pixelu
	 */
	public int getPixelIntensity(int x, int y) {
		Color color = getPixel(x, y);
		return (int) ((0.2126 * color.getRed()) + (0.7152 * color.getGreen()) + (0.0722 * color.getBlue()));
	}

	/**
	 * Vlo�� k��ek na dan� sou�adnice
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @param color - T��da definuj�c� barvu k��ku
	 */
	public void putCross(int x, int y, Color color) {
		putCrossNoDraw(x, y, color);
		repaint();
	}
	
	/**
	 * Vlo�� k��ek na dan� sou�adnice
	 * 
	 * @param point - Sou�adnice k��ku
	 * @param color - T��da definuj�c� barvu k��ku
	 */
	public void putCross(Point point, Color color) {
		putCross(point.x, point.y, color);
	}

	/**
	 * Vlo�� k��ek do bufferu na dan� sou�adnice
	 * 
	 * @param x - sou�adnice X
	 * @param y - sou�adnice Y
	 * @param color - T��da definuj�c� barvu k��ku
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
	 * Vlo�� k��ek do bufferu na dan� sou�adnice
	 * 
	 * @param point - Sou�adnice k��ku
	 * @param color - T��da definuj�c� barvu k��ku
	 */
	public void putCrossNoDraw(Point point, Color color) {
		putCrossNoDraw(point.x, point.y, color);
	}

	/**
	 * Otev�e obr�zek
	 * 
	 * @param file - soubor s obr�zkem
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
			javax.swing.JOptionPane.showMessageDialog(null, "P�i otev�r�n� souboru nastala chyba: " + 
					e.getLocalizedMessage(), "Chyba", javax.swing.JOptionPane.ERROR_MESSAGE);
		}        		
	}
	
	/**
	 * Otev�e soubor SBM
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
			javax.swing.JOptionPane.showMessageDialog(null, "P�i otev�r�n� souboru nastala chyba: "+e.getLocalizedMessage(), 
					"Chyba", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}
	

}
