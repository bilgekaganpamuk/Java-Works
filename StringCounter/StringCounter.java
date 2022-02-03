package counter;

import javax.swing.JOptionPane;
public class StringCounter {
    private int balance;
    private String name;
    private String[] array; /*= {"green", "blue", "black", "yellow", 
                       "brown", "grey"}; */    
    public StringCounter(int balance, String nName) {
        this.balance = balance;
        name = nName;
        stringArrayInit();
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getArray(){
        return array;
    }
    public void setArray(String[] arr) {
        array = arr;
    }
    public String toString() {
        return "Counter name: " + getName() +
                 " balance: " + getBalance() +
                // "\nArray: " + arrayToString();
                " element: " + getElementArray();
           }
    public String arrayToString(){
        String string = "";
        for(int i = 0; i < getArraySize(); i++)
            string += array[i] + " "; // string = string + array[i] + " ";
        return string;
    }
    public void printArray() {
        System.out.println("Print array: " + arrayToString());
    }
    public int getArraySize(){
        return array.length;
    }

    public String getElementArray(){
        int order = getBalance();
        if(order < 0) order = Math.abs(order);
        order = order % getArraySize();
        return array[order];
    }
    public void print() {
        System.out.println(this.toString());
    }
    public void increment() {
        setBalance(getBalance() + 1);
    }
    public void decrement() {
        setBalance(getBalance() - 1);
    }
    public void reset(){
        setBalance(0);
    }
    public void incrementBy(int number) {
        setBalance(getBalance() + number);
    }
    public void decrementBy(int number) {
        setBalance(getBalance() - number);
    }

    public void stringArrayInit(){
        array = new String[getStringNumber()];
        for(int i = 0; i < array.length; i++)
           array[i] = arrayElement(i);
    }
    public int getStringNumber(){
        String number = JOptionPane.showInputDialog(
                                  "Number of array elements: ");
        return Integer.parseInt(number);
    }
    public String arrayElement(int e) {
        String string = JOptionPane.showInputDialog(
               "Enter " + (e + 1) + " element of array: ");
        return string;       
    }
    
    
    
    
}
