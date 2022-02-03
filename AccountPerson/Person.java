package chap_02.AccountPerson;

import java.util.Calendar;

public class Person {
    private String name;
    private Account myAccount;
    private int yearOfBirth;


    public Person(String name, int number, Account acc) {
        this.name = name;
        this.yearOfBirth = number;
        this.myAccount = acc;
    }

    public Person(String name, Account acc) {
        this.name = name;
        this.myAccount = acc;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public Account getMyAccount() {
        return myAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMyAccount(Account myAccount) {
        this.myAccount = myAccount;
    }

    public void deposit(double amount) {
        this.myAccount.deposit(amount);
    }

    public Crowns withdraw(double amount) {
        return this.withdraw(new Crowns(amount));
    }

    private Crowns withdraw(Crowns amount) {
        return getAccount().withdraw(amount);
    }

    public void changeAccountType(AccountType Type) {
        getMyAccount().setType(Type);
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(1);
        return currentYear - getYearOfBirth();
    }

    public Account getAccount() {
        return myAccount;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        sb.append(getClass().getName());
        sb.append("\n Name: ");
        sb.append(getName());
        sb.append(' ');
        sb.append("\n Year: ");
        sb.append(getYearOfBirth());

        sb.append(getMyAccount()).toString();
        return sb.toString();
    }

    public void print() {
        System.out.println(toString());
    }
}
