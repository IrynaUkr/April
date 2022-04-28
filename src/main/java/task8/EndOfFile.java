package task8;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/java-end-of-file/problem?isFullScreen=true
public class EndOfFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (sc.hasNext()) {
            System.out.println(++counter + " " + sc.nextLine());
        }
        sc.close();

    }
}
