package chap_02.Record;


public class Student extends Person {
    private String branchoftstudy;

    public Student() {
        super();
        branchoftstudy = "not given";
    }

    public Student(int key,String name, String sex, String branch) {
        super(key,name, sex);
        this.branchoftstudy = branch;
    }

    public String getBranchoftstudy() {
        return branchoftstudy;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s\n",super.toString(),"Branch of study",getBranchoftstudy());
    }
    public void print(){
        System.out.println(toString());
    }

}
