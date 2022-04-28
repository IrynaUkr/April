package task17;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/java-string-reverse/problem?isFullScreen=true
public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        sc.close();
        String answer = "";
        if (A.length() == 1) {

            answer = "Yes";
        } else {
            for (int i = 0; i < A.length() / 2; i++) {
                if (A.charAt(i) == A.charAt(A.length() - 1 - i)) {
                    answer = "Yes";
                } else {
                    answer = "No";
                }
            }
        }
        System.out.println(answer);
    }
}
