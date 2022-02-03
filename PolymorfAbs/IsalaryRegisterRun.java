package chap_02.PolymorfAbs;

public class IsalaryRegisterRun
{
    public static void main(String[] args) {
        ISalaryRegister  register = new ISalaryRegister(17);
        Isalary fsPerson = new FixedSalaryPerson("alena",Sex.FEMALE,new Crowns(22000),new Crowns(500));
        TaskSalaryPerson tsPerson = new TaskSalaryPerson("Ivan",Sex.MALE,160,new Crowns(235),0.6);
        register.insert(fsPerson);
        register.insert(tsPerson);
        for(int i = 0;i<= register.getTop(); i++){
            register.getElement(i).print();
        }
        for(int i = 0;i<= register.getTop(); i++){
          Crowns crowns = register.getElement(i).salaryCalculation();
          System.out.println("Salary" + crowns);
        }
        for(int i = 0;i<= register.getTop(); i++){
            String string = register.getElement(i).tostring();
            System.out.println("toString: " + string);
        }
    }
}
