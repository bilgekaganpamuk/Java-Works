package chap_02.Record;

public class RecordRun {
    public static void main(String[] args) {
        Record record = new Record(12);
        record.print();
        Book book = new Book(23,"Fallet","Pillere Zenne");
        book.print();
        Person person = new Person(13,"Jan", "muz");
        person.print();
        Employee employee= new Employee(22,"exa","Female","manager",new Crowns(38000));
        employee.print();
        Student student = new Student(15,"Ivan","male","Chemistry");
        student.print();
        Record recordX;
        recordX = book;
        System.out.println("Polymorphism");
        recordX.print();
        int number = recordX.getKey();
        String author = book.getAuthor();
        Person personX;
        personX = student;
        personX.getName();
        personX.print();
    }
}
