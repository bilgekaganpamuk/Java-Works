package chap_02.registr;

import java.util.Arrays;

public class Register {
    private int array[];
    private int top;

    public Register(int number) {
        array = new int[number];
        top = -1;
    }

    public int getTop() {
        return top;
    }

    public void insert(int element) {
        if ((top + 1) < array.length) {
            top = top + 1;
            array[getTop()] = element;
        }
        else{
            System.out.println("Register is full");
        }
    }

    @Override
    public String toString() {
    String t = String.format("%5s %9s\n","index","Value");
    for (int i=0;i<=top;i++){
        t=t+String.format("%5d %9d \n",i,array[i]);
    }
    return t;
    }
    public void print(){
        System.out.println(toString());
    }
    public int getelement(int i){
        int element = 0;
        if(i>=0 && i<=top){
            element=array[i];
        }
        else{
           System.out.println("Is out of range");
        }
        return element;
    }
    public int find(int element){
        int result = -1;
        for(int i = 0;i<=top;i++){
            if(array[i]==element){
                result=i;
                break;
            }
        }
        return result;
    }
    public void remove(int element){
        int result = find(element);
        if(result > -1){
            for(int i = result;i<getTop();i++){
                array[i]=array[i+1];
                top -=1;
                System.out.println("Succesfuly Removed");
            }

        }
        else {
            System.out.println("is not in The register");
        }
    }
public int minimum(){
        int min = getelement(0);
        for ( int i=0;i<getTop();i++){
            if(getelement(i)< min){
                min=getelement(i);
            }
        }
        return min;
}
public int maximum(){
        int max = getelement(0);
        for ( int i=0;i<getTop();i++){
            if (getelement(i)>max){
                max = getelement(i);
            }
        }
        return max;
}
public Register adjustRegister(int liminmin, int limitmax){
        Register newReg = new Register(array.length);
        for(int i=0;i<=getTop();i++){
            if(getelement(i)>=liminmin && getelement(i)<=limitmax){
                newReg.insert(getelement(i));
            }
        }
        return newReg;
}
public void removeAll(){
        top = -1;
}
}
