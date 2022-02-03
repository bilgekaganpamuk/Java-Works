package chap_02.AccountPerson;

public class AccountRun
{
    public static void main(String[] args) {
    Account account123 = new Account(123,new Crowns(200));

    account123.print();
    account123.setType(AccountType.SPECIAl);
    account123.deposit(new Crowns(33.56));
    account123.print();
    Crowns crowns = new Crowns(893.76);
    Crowns crownA = account123.withdraw(crowns);
    System.out.println("Remaining Crowns"+crownA.toString());
    account123.print();

    }
}
