package task1;

import java.util.Scanner;
// https://www.hackerrank.com/challenges/java-if-else/problem?isFullScreen=true
public class IfElse {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N % 2 != 0){
            System.out.println("Weird");
        }else if ((N >= 2 & N <= 5) | (N > 20) ){
            System.out.println("Not Weird");
        }else {
            System.out.println("Weird");
        }
        scanner.close();
    }
}
