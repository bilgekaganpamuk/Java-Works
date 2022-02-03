package chap_02.PolymorfAbs;

public class ISalaryRegister {
    private Isalary array[];
    private int top;

    public ISalaryRegister(int number){
        top = -1;
        array = new Isalary[number];
    }

    public int getTop() {
        return top;
    }
    public void insert(Isalary isalary){
        if((top+1)< array.length){
            top +=1;
            array[getTop()] = isalary;
        }
        else {
            System.out.println("Register is full");
        }
    }
    public Isalary getElement(int i){
        Isalary isalary = null;
        if (i>=0&&i<array.length){
            isalary = array[i];

        }
        else{
            System.out.println("%s %d %s");
        }
        return isalary;
    }
}
