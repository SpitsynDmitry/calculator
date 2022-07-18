package pro.sky.java.cource2.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plus(int a, int b){
        return a + b;
    }
    public int minus(int a, int b){
        return a - b;
    }
    public int multiply(int a, int b){return a * b;}
    public double divide(int a, int b){
        return (double) a / b;
    }
}
