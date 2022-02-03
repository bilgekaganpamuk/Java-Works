package chap_02.AccountPerson;

public class PersonRun {
    public static void main(String[] args) {
Account account = new Account(123,new Crowns(200),AccountType.SAVING);
Person person = new Person("Jan",1999,account);
person.print();
person.deposit(3001.23);
person.changeAccountType(AccountType.CURRENT);
person.print();
Crowns crown = person.withdraw(4286.89);
crown.print();
person.print();

    }
}
