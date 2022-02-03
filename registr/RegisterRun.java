package chap_02.registr;

public class RegisterRun {
    public static void main(String[] args) {
        Register rgstr = new Register(5);
        rgstr.insert(9);
        rgstr.insert(11);
        System.out.println(rgstr.find(11));
        rgstr.remove(9);
        System.out.println("Modified Register");
        Register d = rgstr.adjustRegister(12,15);
        d.print();
    }
}
