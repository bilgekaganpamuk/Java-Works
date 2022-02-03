package chap_02.registr;
import chap_02.registr.Person;
public class PersonRgstr extends Person {
    private Person array[];
    private int top;

    // konstruktor
    public PersonRgstr(int number) {

        top = -1;
       array = new Person[number];
    }

    public int getTop() {
        return top;
    }

    public Person[] getArray() {
        return array;
    }

    public void insert(Person person) {
        if ((top + 1) < array.length) {
            top += 1;
            array[top] = person;
        } // topIncr();
        else System.out.println("Registr je obsazeny");
    }

    public Person getElement(int i) {
        Person person = null;
        if (i >= 0 && i < array.length)
            person = array[i];
        else System.out.printf("%s %d %s\n", "Index", i, " out of range");
        return person;
    }

    public int find(Person person) {
        int result = -1;
        for
        (int i = 0; i <= getTop(); i++)
            if (array[i] == person) {
                result = i;
                break;
            }
        return result;
    }

    public void remove(Person person) {
        int result = find(person);
        if (result == -1) System.out.printf("%s %d %s \n"
                , "Element", person, "is not in the register");
        else this.remove(result);
    }

    public void remove(int index) {
        for (int i = 0; i < top - index; i++)
            array[index + i] = array[index + i + 1];
        top -= 1;
        System.out.println("Element removed");
    }

    public String toString() {
        String t = String.format("%5s %16s\n", "Index", "value");
        for (int i = 0; i <= getTop(); ++i)
            t = t + String.format("%5d ", i) + array[i].toString(); //getElement(i).toString()
        return t;
    }

    public void print() {
        System.out.println(this.toString());
    }


    public int  minimalWeight() {
            int min = getElement(0).getWeight();
            for(int i=1;i<=getTop();i++){
                if(getElement(i).getWeight()<min) min = getElement(i).getWeight();
            }
            return min;

    }

    public Person maxAge() {
        Person person = array[0];
        for (int i = 0; i <= getTop(); i++)
            if (array[i].getAge() > person.getAge())
                person = array[i];
        return person;
    }


}
