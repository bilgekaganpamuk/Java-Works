package chap_02.registr;

import java.util.Calendar;

import chap_02.registr.PersonRgstr;

public class Person {

    private String name;
    private int yearOfBirth;
    private int weight;

    public Person() {
        name = "Not given";
        yearOfBirth = 0;
        weight = 0;
    }

    public Person(String name, int yearOfBirth, int weight) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getAge() {
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(1);
        return currentYear - this.getYearOfBirth();
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return String.format("%5s %s %15s %4d %5s %d\n",
                "Name", getName(), "year of birth:", getYearOfBirth(),
                "weight:", getWeight());
    }

    public void print() {
        System.out.println(this.toString());
    }

}
