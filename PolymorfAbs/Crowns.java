package chap_02.PolymorfAbs;

public class Crowns {
    private long hellers;
    private static final int HELLERS_PER_CROWN = 100;

    //constructors
    public Crowns(double amount) {
        this.hellers = Math.round(amount * HELLERS_PER_CROWN);
    }

    public Crowns(Crowns crowns) {
        hellers = crowns.getHellers();
    }

    //methods
    public long getCrowns() {
        return getHellers() / HELLERS_PER_CROWN;
    }

    public long getHellers() {
        return hellers;
    }

    public long getLeftHellers() {
        return getHellers() % HELLERS_PER_CROWN;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (getHellers() < 0) sb.append('-');
        sb.append(Math.abs(getCrowns()));
        sb.append(',');
        long leftHellers = Math.abs(getLeftHellers());
        if (leftHellers == 0) sb.append("00");
        else {
            if (leftHellers > 0 && leftHellers < 10) sb.append('0');
            sb.append(leftHellers);
        }
        sb.append(" CZK");
        return sb.toString();
    }

    public void print() {
        System.out.println(toString());
    }

    public boolean isZero() {
        return getHellers() == 0;
    }

    public Crowns plus(Crowns amount) {
        return new Crowns(1.0 * (this.getHellers() + amount.getHellers())
                / HELLERS_PER_CROWN);
    }

    public Crowns minus(Crowns amount) {
        return new Crowns((double) (this.getHellers() - amount.getHellers())
                / HELLERS_PER_CROWN);
    }

    public Crowns multiplication(double bonusRate) {
        return new Crowns(getHellers() * bonusRate / HELLERS_PER_CROWN);
    }

}
