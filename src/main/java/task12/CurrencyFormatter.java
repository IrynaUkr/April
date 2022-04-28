package task12;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-currency-formatter/problem?isFullScreen=true
public class CurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String us = n.format(payment);
        NumberFormat n1 = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = n1.format(payment);
        NumberFormat chFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = chFormat.format(payment);
        NumberFormat frFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = frFormat.format(payment);


        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}


