package Calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2 = 0;
        do {
            System.out.println("Input number for the function you want to use");
            System.out.print("1) Factorial\n2) Power\n3) Square Root\n4) Log\n" +
                    "any key to exit");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            if((choice==1) || (choice==3) || (choice==4)) {
                try{
                    System.out.print("Enter the number : ");
                    number1 = scanner.nextDouble();
                } catch (InputMismatchException error) {
                    return;
                }
            }
            else {
                try {
                    System.out.print("first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("second number : ");
                    number2 = scanner.nextDouble();
                } catch (InputMismatchException error) {
                    logger.error("Invalid");
                    return;
                }
            }
            switch (choice) {
                case 1:
                    System.out.println("Factorial : " + calculator.factorial(number1));
                    break;
                case 2:
                    System.out.println("X^Y : " + calculator.powered(number1, number2));
                    break;
                case 3:
                    System.out.println("Sqrt : " + calculator.root(number1));
                    break;
                case 4:
                    System.out.println("Log : " + calculator.log(number1));
                    break;
                default:
                    System.out.println("exited");
                    return;
            }
        } while (true);
    }



    public double root(double number1) {
        double result = 0;
        double number = 0.5;
        result = powered(number1,number);
        return result;
    }


    public double log(double number1) {
        double result = 0;
        result = Math.log(number1);
        return result;
    }

    public double powered(double number1, double number2) {
        double result = 0;
        result = Math.pow(number1, number2);
        try {
            if(result == Double.NaN) {
                throw new ArithmeticException("Case of NaN");
            }
            else {
                result=result;
            }
        } catch (ArithmeticException error) {
            logger.error("EXCEPTION - Cannot be found " + error.getLocalizedMessage());
        } finally {
            logger.info("RESULT - " + result);
        }
        return result;
    }

    public double factorial(double number1) {
        double result = 1;
        int i = 1;
        int x = (int) number1;
        try {
            logger.info("FACTORIAL - " + number1);
            if(number1!=x) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN");
            }
            else if(number1<0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN");
            } else if(number1>=0) {
                for(i=2;i<=number1;i++) {
                    result=result*i;
                }
            }
        } catch (ArithmeticException error) {
            logger.error("EXCEPTION - Cannot be found " + error.getLocalizedMessage());
        } finally {
            logger.info("RESULT - " + result);
        }
        return result;
    }
}
