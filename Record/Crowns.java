package chap_02.Record;

public class Crowns {   private long hellers;
    private static final int HELLER_PER_CROWN = 100;

    public Crowns(double amount){
        this.hellers = Math.round(amount*HELLER_PER_CROWN);

    }
    public Crowns(chap_02.AccountPerson.Crowns crowns){
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
    public chap_02.AccountPerson.Crowns plus(chap_02.AccountPerson.Crowns amount){
        return new chap_02.AccountPerson.Crowns(1.0 * (this.getHellers()+amount.getHellers()) / HELLER_PER_CROWN);
    }

    public chap_02.AccountPerson.Crowns minus(chap_02.AccountPerson.Crowns amount){

        return new chap_02.AccountPerson.Crowns((double) (this.getHellers()-amount.getHellers()) / HELLER_PER_CROWN);
    }

    public void print(){
        System.out.println(toString());

    }
    public void setHellers(int hellers) {
        this.hellers = hellers;
    }
}
