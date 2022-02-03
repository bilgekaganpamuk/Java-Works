package chap_02.AccountPerson;

public class Crowns {
   private long hellers;
   private static final int HELLER_PER_CROWN = 100;

    public Crowns(double amount){
        this.hellers = Math.round(amount*HELLER_PER_CROWN);

    }
    public Crowns(Crowns crowns){
        hellers=crowns.getHellers();
    }

    public long getCrowns() {
        return getHellers()/HELLER_PER_CROWN;
    }

    public long GetleftHellers(){
        return getHellers()%HELLER_PER_CROWN;
    }
    public long getHellers() {
        return hellers;
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer("");
       if(getHellers()<0){
           sb.append("-");
       }
       sb.append(Math.abs(getCrowns()));
       sb.append(",");
       long leftHellers = Math.abs(GetleftHellers());
       if(leftHellers==0){
           sb.append("00");
       }
       else {
           if (leftHellers>0 && leftHellers<10){
               sb.append("0");
           }
           sb.append(leftHellers);
       }
       sb.append(" CZC");

       return sb.toString();
    }
    public Crowns plus(Crowns amount){
    return new Crowns(1.0 * (this.getHellers()+amount.getHellers()) / HELLER_PER_CROWN);
    }

    public Crowns minus(Crowns amount){

        return new Crowns((double) (this.getHellers()-amount.getHellers()) / HELLER_PER_CROWN);
    }

    public void print(){
       System.out.println(toString());

    }
    public void setHellers(int hellers) {
        this.hellers = hellers;
    }

}
