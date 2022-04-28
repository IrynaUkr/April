package task15;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/java-strings-introduction/problem?isFullScreen=true
public class StringIntro {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();
        printSumLength(A, B);
        compareString(A, B);
        printCapitalizedStrings(A, B);
    }

    private static void printCapitalizedStrings(String A, String B) {
        String result = getCapitalString(A) + " " + getCapitalString(B);
        System.out.println(result);
    }

    private static void compareString(String A, String B) {
        if (A.charAt(0) > B.charAt(0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void printSumLength(String A, String B) {
        int sumLength = A.length() + B.length();
        System.out.println(sumLength);
    }

    private static String getCapitalString(String str) {
        int lengthString = str.length();
        String capitalA = "";
        if (lengthString == 1) {
            capitalA = str.substring(0, 0).toLowerCase();
        } else {
            capitalA = str.substring(0, 1).toUpperCase() + str.substring(1, lengthString).toLowerCase();
        }
        return capitalA;
    }
}
