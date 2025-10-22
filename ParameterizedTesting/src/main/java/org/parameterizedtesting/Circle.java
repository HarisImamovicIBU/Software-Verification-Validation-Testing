package org.parameterizedtesting;


public class Circle {
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public double calculateArea(){
        return Math.round(Math.PI*radius*radius*100.0)/100.0;
    }
}
