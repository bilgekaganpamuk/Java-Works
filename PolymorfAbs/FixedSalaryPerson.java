package chap_02.PolymorfAbs;

public class FixedSalaryPerson extends Person implements Isalary {
    private Crowns fixedamount;
    private Crowns bonus;

    public FixedSalaryPerson(String name, Sex sex, Crowns fixedamount, Crowns bonus) {
        super(name, sex);
        this.fixedamount = fixedamount;
        this.bonus = bonus;
    }

    public Crowns getFixedamount() {
        return fixedamount;
    }

    public Crowns getBonus() {
        return bonus;
    }


    public String tostring() {
        return super.toString() + "Salary: " + salaryCalculation().toString();
    }


    public void print() {
        System.out.println(tostring());
    }

    public Crowns salaryCalculation() {
        return getFixedamount().plus(getBonus());
    }
}
