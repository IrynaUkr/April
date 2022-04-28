package task14;

import java.util.Scanner;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/pattern-syntax-checker/problem?isFullScreen=true
public class PatternSyntaxChecker {


    public static void check() {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Throwable t) {
                System.out.println("Invalid");
            }
            testCases--;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {

            System.out.println(scan.nextInt());
        }
        scan.close();
    }

}
