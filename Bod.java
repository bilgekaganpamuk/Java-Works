package chap_02;
import chap_02.Drawing.BaseCanvas;
import chap_02.Drawing.Gui;

import java.awt.Color;
public class Bod {
   private int x;
   private int y;
   private Color barva;
   private BaseCanvas obraz = Gui.getInstance().getCanvas();
   private Color barvaPozadi = Color.white;
   public Bod() {
       //x = 0; y = 0; 
       //barva = Color.red;
       this(0, 0, Color.red);
    }
   public Bod(int x, int y) {
       //this.x = x; 
       //this.y = y;
       this(x, y, Color.red);
    }
   public Bod(int x, int y, Color barva) {
       this.x = x;
       this.y = y;
       this.barva = barva;
    }
   public Bod(int x, int y, String barva) {
       this.x = x; this.y = y;
       this.barva = this.stringToColor(barva);
    }
   // kopirovaci konstruktor
   public Bod(Bod bod) {
       x = bod.getX();
       y = bod.getY();
       barva = bod.getBarva();
    }
    
   public int getX() {
       return x;
    }
   public int getY() {
       return y;
    }
   public Color getBarva() {
       return barva;
    }
   public BaseCanvas getObraz() {
       return obraz;
    }
    public Color getBarvaPozadi() {
        return barvaPozadi;
    }
   public void setX(int x) {
       this.x = x;
    }
   public void setY(int y) {
       this.y = y;
    }
   public void setBarva(Color barva) {
       this.barva = barva;
    }
   public void vykresli() {
       getObraz().putPixel(getX(), getY(), getBarva());
    }
    public void smaz() {
        getObraz().putPixel(getX(), getY(), getBarvaPozadi());
    }
    
    public void vykresli(int x1, int y1) {
        getObraz().putPixel(getX() + x1, getY() + y1, getBarva());
    }
    public void smaz(int x1, int y1) {
        getObraz().putPixel(getX() + x1, getY() + y1, getBarvaPozadi());
    }
    
    public void posunSouradnic(int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    public void posunBod(int dx, int dy) {
        this.smaz();
        this.posunSouradnic(dx, dy);
        this.vykresli();
    }
    
    public String toString(){
        return "X: " + getX() + " Y: " + getY() + 
         " barva: " + getBarva();
    }
    public void tisk() {
        System.out.println(toString());
    }
    public void pauza(int doba) {
        try {
           Thread.sleep(doba);
           } catch(InterruptedException e) {
            System.out.println("Chyba vlakno pauza");
        }
    }
   public Color stringToColor(String barva) {
       switch(barva) {
           case "cerna": return Color.black;
           case "cervena": return Color.red;
           case "modra": return Color.blue;
           case "zelena": return Color.green;
           case "ruzova": return Color.pink;
           default: return Color.red;
        }
    }
   public int delkaX(Bod bod) {
       return Math.abs(getX() - bod.getX());
    }
   public int delkaY(Bod bod) {
       return Math.abs(getY() - bod.getY());
    }
   public Bod soucet(Bod b) {
       Bod vysledek = new Bod(getX() + b.getX(), getY() + b.getY());
       return vysledek;
    }
   public Bod rozdil(Bod b) {
       return new Bod(getX() - b.getX(), getY() - b.getY());
    }
}





