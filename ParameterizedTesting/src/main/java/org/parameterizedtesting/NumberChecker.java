package org.parameterizedtesting;

public class NumberChecker {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    public boolean isPrime(int number){
        if(number<2){
            return false;
        }
        if(number==2){
            return true;
        }
        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
    public long fibonacci(int number){
        if(number==0){
            return 0;
        }
        else if(number==1){
            return 1;
        }
        return fibonacci(number-1)+fibonacci(number-2);
    }
}