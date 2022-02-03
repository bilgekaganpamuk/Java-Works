package chap_02.registr;

public class PersonRgstrRun {
    public static void main(String[] args) {
        PersonRgstr register = new PersonRgstr(6);
        Person person = new Person("jana",1975,66);
        register.insert(person);
        person = new Person("adam",1963,76);
        register.insert(person);
        person = new Person("karel",1987,94);
        register.insert(person);
        person = new Person("ivan",1948,84);
        register.insert(person);
        person = new Person("iveta",1976,68);
        register.insert(person);


    }
}
