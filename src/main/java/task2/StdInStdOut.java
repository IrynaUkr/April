package task2;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem?isFullScreen=true
public class StdInStdOut {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println(scan.nextInt());
        }
        scan.close();
    }
}
