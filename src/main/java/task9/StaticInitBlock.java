package task9;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/java-static-initializer-block/problem?isFullScreen=true
public class StaticInitBlock {
    static int B;
    static int H;
    static boolean flag;

    static {
        Scanner scan = new Scanner(System.in);
        try {
            B = scan.nextInt();
            H = scan.nextInt();
            flag = B > 0 & H > 0;
            if (!flag) {
                System.out.println("java.lang.Exception: Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println();
        } finally {
            scan.close();
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}





