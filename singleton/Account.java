package chap_02.singleton;

import chap_02.AccountPerson.AccountType;
import chap_02.AccountPerson.Crowns;

public class Account {
    private int number;
    private Crowns balance;
    private AccountType type;
    private static Account singleton;

    private Account(int number, Crowns balance, AccountType type) {
        this.number = number;
        this.balance = balance;
        this.type = type;
    }

    public static Account getInstance() {
        if (singleton == null) {
            singleton = new Account(123, new Crowns(200), AccountType.SPECIAl);
        }
        return singleton;
    }

    public Account(int number, Crowns balance) {
        this.number = number;
        this.balance = balance;

    }

    public AccountType getType() {
        return type;
    }

    public void deposit(Crowns amount) {
        this.balance = balance.plus(amount);
    }

    public void deposit(double amount) {
        this.deposit(new Crowns(amount));
    }

    public void setnumber(int number) {
        this.number = number;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Crowns getBalance() {
        return balance;
    }

    public void setBalance(Crowns balance) {
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Crowns withdraw(Crowns amount) {
        this.balance.minus(amount);
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }

    public void print() {
        System.out.println(toString());

    }

}
