package chap_02.PolymorfAbs;

public class Person {
    private String name;
    private Sex sex;

    //constructor
    public Person(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public String toString() {
        return "Name: " + getName() + " sex: " + getSex();
    }

    public void print() {
        System.out.println(toString());
    }
    // public abstract Crowns salaryCalculation();

}
