package chap_02.RecordPerson;

public class PersonRun
{
    public static void main(String[] args) {

        Person jana= new Person("jana","zena");
        jana.print();
        Student Karel = new Student("Karel","Male","Maths");
        Karel.print();
        Person person;
        person = Karel;
        person.print();
        String string = person.getName();
        System.out.println("Name: "+string);
        string = person.getSex();
        System.out.println("Sex: "+ string);
    Person[] personArray = new Person[3];
    personArray[0]=jana;
    personArray[1]=Karel;
    personArray[2]=new Person("Janda","male");
    for(int i=0;i<personArray.length;i++){
        personArray[i].print();
    }
    }
}
