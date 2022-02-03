package chap_02;
import java.awt.Color;
public class BodTest {
   public static void main(String[] args) {
       Bod bodA = new Bod(100,110, Color.red);
       Bod bodB = new Bod(230, 400, "modra");       
       // vykresleni 4x bodA    
       bodA.vykresli();
       bodA.vykresli(0, 1);
       bodA.vykresli(0, 2); 
       bodA.vykresli(0, 3);
       bodA.pauza(20);
       // vykresleni 3x bodB
       bodB.vykresli();
       bodB.posunSouradnic(1, 0);
       bodB.vykresli();
       bodB.posunSouradnic(1, 0);
       bodB.vykresli();
       bodB.pauza(20);
       bodA.posunSouradnic(40, 50);
       // vykresleni svisle cary
       for(int i = 0; i < 200; i++) {
         bodA.vykresli(0, i);
         bodA.pauza(40);
       }
       bodB.posunBod(30, 20);
       // vykresleni vodorovne cary
       for(int i = 0; i < 100; i++) {
      	 bodB.vykresli(i, i);
      	 bodB.pauza(40);
       }
       // smazani cary
       for(int i = 0; i < 100; i++) {
      	 bodB.smaz(i, i);
      	 bodB.pauza(40);
     }
   }   
}
