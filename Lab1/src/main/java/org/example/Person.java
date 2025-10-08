package org.example;

//Task 3
public class Person {
    private int age;
    public Person(int age){
        if(age<0){
            throw new IllegalArgumentException("A person's age cannot be negative!");
        }
        this.age=age;
    }
    public boolean isAdult(){
        return this.age>=18;
    }
    //Task 6
    public boolean canGoToSchool(){
        return this.age>=6;
    }
}
