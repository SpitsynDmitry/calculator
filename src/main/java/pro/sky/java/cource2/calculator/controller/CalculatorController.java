package pro.sky.java.cource2.calculator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.cource2.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController (CalculatorService calculatorService) {
        this.calculatorService=calculatorService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String greetings() {
        return "<h1> Добро пожаловать в калькулятор </h1>";
    }

    @GetMapping
    public String plus(@RequestParam(name = "num1",required = false) Integer a,
                       @RequestParam(name = "num1",required = false) Integer b) {
        if (a == null || b == null) {
            return " Какой то из параметров не передан!";
        }
        return buildResultString(a, b, " + ",calculatorService.plus(a,b));
    }

    @GetMapping
    public String minus(@RequestParam(name = "num1",required = false) Integer a,
                        @RequestParam(name = "num1",required = false) Integer b) {
        if (a == null || b == null) {
            return " Какой то из параметров не передан!";
        }
        return buildResultString(a, b, " - ",calculatorService.minus(a,b));
    }

    @GetMapping
    public String multiply(@RequestParam(name = "num1",required = false) Integer a,
                           @RequestParam(name = "num1",required = false) Integer b) {
        if (a == null || b == null) {
            return " Какой то из параметров не передан!";
        }
        return buildResultString(a, b, "*",calculatorService.multiply(a,b));
    }

    @GetMapping
    public String divide(@RequestParam(name = "num1",required = false) Integer a,
                         @RequestParam(name = "num1",required = false) Integer b) {
        if (a == null || b == null) {
            return " Какой то из параметров не передан!";
        }
        if (b == 0) {
            return " на ноль делить нельзя";
        }
        return buildResultString(a, b, "/",calculatorService.divide(a,b));
    }

    private String buildResultString(int a,
                                     int b,
                                     String operation,
                                     double result) {

        return String .format("", a , operation, b, result);
    }

}
