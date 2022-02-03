package chap_02.AccountPerson;

public class CrownsRun
{
    public static void main(String[] args) {
        Crowns cr1=new Crowns(-0.05);
        cr1.print();
        Crowns cr2 = new Crowns(17.98);
        cr2.print();

        Crowns crownC = cr1.plus(cr2);
        crownC.print();
        Crowns crownsD = cr1.minus(cr2);
        crownsD.print();
    }
}
