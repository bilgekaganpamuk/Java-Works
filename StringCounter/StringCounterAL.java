package counterAL;

import javax.swing.*;
import java.util.ArrayList;

public class StringCounterAL {
    private int balance;
    private String name;
    private ArrayList<String>array;

    public StringCounterAL(int balance, String nName) {
        this.balance = balance;
        name = nName;
        array = new ArrayList<String>();
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
    public ArrayList getArray(){
        return array;
    }
    public void setArray(ArrayList arr) {
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
            string += array.get(i) + " "; // string = string + array[i] + " ";
        return string;
    }
    public void printArray() {
        System.out.println("Print array: " + arrayToString());
    }
    public int getArraySize(){
        return array.size();
    }

    public String getElementArray(){
        int order = getBalance();
        if(order < 0) order = Math.abs(order);
        order = order % getArraySize();
        return array.get(order);
    }
    public void print() {
        System.out.println(this.toString());
    }
    public void increment() {
        increment(1);
    }
    public void decrement() {
        decrement(1);
    }
    public void reset(){
        setBalance(0);
    }
    public void increment(int number) {
        setBalance(getBalance() + number);
    }
    public void decrement(int number) {
        setBalance(getBalance() - number);
    }

    public void stringArrayInit(){
       int arrSize = getStringNumber();
        for(int i = 0; i < arrSize; i++)
           array.add(arrayElement(i));
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
