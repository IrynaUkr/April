package task18;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Anagram {
    static boolean isAnagram(String a, String b) {
        String atoLowerCase = a.toLowerCase();
        String bToLowerCase = b.toLowerCase();
        return sortString(atoLowerCase).equals(sortString(bToLowerCase));
    }

    private static String sortString(String a) {
        char[] chars = a.toCharArray();
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j+1]=temp;
                }
            }
        }
       return new String(chars);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
