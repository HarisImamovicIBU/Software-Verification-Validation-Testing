package org.example;

import java.util.Arrays;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    //Task 1
    public int factorial (int num){
        if(num<0){
            throw new ArithmeticException("Cannot calculate factorial of a negative!");
        }
        else if(num==0 || num==1){
            return 1;
        }
        else{
            int prod = 1;
            for(int i=2;i<=num;i++){
                prod*=i;
            }
            return prod;
        }
    }

    //Task 2
    public String[] stringToArrayOfWords(String sentence){
        if(sentence==null){
            return null;
        }
        return sentence.split(" ");
    }

    //Task 4
    public int[] sort(int[] arrayToSort){
        if(arrayToSort.length==0){
            return new int[]{};
        }
        Arrays.sort(arrayToSort);
        return arrayToSort;
    }
}