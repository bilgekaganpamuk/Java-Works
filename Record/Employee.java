package chap_02.Record;

public class Employee extends Person {
    private String position;
    private Crowns salary;
    public Employee(){
        super(); position = "Not given"; salary=new Crowns(0);

    }
    public Employee(int key,String name,String sex,String position, Crowns salary){
        super(key,name,sex);
        this.position=position;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s",super.toString(),"Position: ",getPosition(),"Salary:",getSalary());
    }

    public String getPosition() {
        return position;
    }

    public Crowns getSalary() {
        return salary;
    }
}
