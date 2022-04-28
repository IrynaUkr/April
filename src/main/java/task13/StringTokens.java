package task13;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        scan.close();

        String s1 =s.replaceAll("[!,?._'@]+", " ");
        String[] splitString =s1.split(" ");
        int count =splitString.length;

        for(String str :splitString){
            if (str.isEmpty()){
                count--;}
        }
        System.out.println(count);
        for(String str :splitString){
            if (!str.isEmpty()){
                System.out.println(str);}
        }
    }
}


