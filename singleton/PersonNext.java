package chap_02.singleton;

import chap_02.AccountPerson.Account;
import chap_02.AccountPerson.AccountType;
import chap_02.AccountPerson.Crowns;

import java.util.Calendar;

public class PersonNext
{
    private String name;
    private chap_02.AccountPerson.Account myAccount;
    private int yearOfBirth;


    public PersonNext(String name, int number, chap_02.AccountPerson.Account acc) {
        this.name = name;
        this.yearOfBirth = number;
        this.myAccount = acc;
    }

    public  PersonNext(String name, chap_02.AccountPerson.Account acc) {
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

    public chap_02.AccountPerson.Account getMyAccount() {
        return myAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMyAccount(chap_02.AccountPerson.Account myAccount) {
        this.myAccount = myAccount;
    }

    public void deposit(double amount) {
        this.deposit(new Crowns(amount));
    }

    public Crowns withdraw(double amount) {
        return this.withdraw(new Crowns(amount));
    }

    private Crowns withdraw(Crowns amount) {
        return chap_02.singleton.Account.getInstance().withdraw(amount);
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
        sb.append("\n");
        sb.append(chap_02.singleton.Account.getInstance());
        sb.append(getMyAccount()).toString();
        return sb.toString();
    }
    public void deposit(Crowns amount){
        chap_02.singleton.Account.getInstance().deposit(amount);
    }

    public void print() {
        System.out.println(toString());
    }
}
