package chap_02.RecordPerson;

public class Person {
    private String name;
    private String Sex;

    public Person(){
       this.name = "not Given";
       this.Sex = "not Given";
    }
    public Person(String name, String sex){
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
        StringBuffer sb = new StringBuffer("");
        sb.append("Name: ");
        sb.append(getName());
        sb.append("\n Sex: ");
        sb.append(getSex());
        return sb.toString();
    }
    public void print(){
        System.out.println(toString());
    }

}
