
public class Citac {
	private int stav;
	private String jmeno = "nezadane";
	
	public void setJmeno(String noveJmeno) {
	    jmeno = noveJmeno;
	   }
	public String getJmeno() {
	    return jmeno;
	   }
	
	public int getStav() {
	    return stav;
	   }
	public void setStav(int nStav) {
	    stav = nStav;
	   }
	   
	public void pricti() {
	    //stav = stav + 1;
	    this.setStav(this.getStav() + 1);
	   }
	   
	public void odecti() { 
	   //stav -= 1;
	   this.setStav(this.getStav() - 1);
    }
    public void nuluj() {
        //stav = 0;
        this.setStav(0);
    }
    public void tisk() {
        System.out.println("Jmeno citace: "+ this.getJmeno() + " stav: " + getStav());
    }
    
    public void prictiCislo(int cislo) {
        stav += cislo;
    }
    
    public void odectiCislo(int cislo) {
        stav -= cislo;
    }
    
    
    
}
