package chap_02;
public class Krizek {
   private Bod stred;
   private int delka = 3;
   
   public Krizek() {
       stred = new Bod();
    }
   public Krizek(Bod bod, int delka) {
       //stred = bod; // normalni prirazeni
       stred = new Bod(bod); // pouziti kopirivaciho konstruktoru
       this.delka = delka;
    }
   public Krizek(Krizek kr) {
       stred = new Bod(kr.getStred());
       delka = kr.getDelka();
    }
   //modifikacni a pristupove metody
   public Bod getStred() {
       return stred;
    }
   public int getDelka() {
       return delka;
    }
   public void setStred(Bod bod) {
       stred = bod;
    }
   public void setDelka(int delka) {
       this.delka = delka;
    }
   public void vykresli() {
       for(int i = 0; i < getDelka() * 2 + 1; i++){
           //vodorovne
           getStred().vykresli( - getDelka() + i, 0);
           //svisle
           getStred().vykresli(0, - getDelka() + i);
           getStred().pauza(20);
        }
    }
   public void smaz() {
       for(int i = 0; i < getDelka() * 2 + 1; i++){
           //vodorovne
           getStred().smaz( - getDelka() + i, 0);
           //svisle
           getStred().smaz(0, - getDelka() + i);
           getStred().pauza(20);
        }
    }
   public void posun(int dx, int dy) {
       this.smaz();
       this.getStred().posunSouradnic(dx, dy);
       this.vykresli();
    }
   public void posunSouradnic(int dx, int dy) {
       this.getStred().posunSouradnic(dx, dy);
    }
   public void posunNemas(int dx, int dy) {
       this.getStred().posunSouradnic(dx, dy);
       this.vykresli();
    }
    
   public String toString() {
       return "Stred: " + getStred().toString() + " delka: " +
                         getDelka();
       }
   public void tisk() {
       System.out.println(toString());
    }
}



