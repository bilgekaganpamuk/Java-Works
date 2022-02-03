package chap_02.Record;

public class Person extends Record {
    private String name;
    private String Sex;

    public Person(){
        this.name = "not given";
        this.Sex = "not given";
    }
    public Person(int Key,String name,String sex){
        super(Key);
        this.name=name;
        this.Sex=sex;

    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return Sex;
    }

    @Override
    public String toString() {
 return String.format("%s %s %s\n", super.toString(),"Key"+getKey(),"Name:", getName(),"Sex",getSex());
    }
    public void print(){
        System.out.println(toString());
    }
}
