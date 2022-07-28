package task21;
//https://www.hackerrank.com/challenges/java-hashset/problem?isFullScreen=true
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        Set<String> all = new HashSet<>();
        int unique = 0;
        for (int k = 0; k < t; k++) {
            boolean add = all.add((pair_left[k] +" "+ pair_right[k]));
            if(add){
                unique++;
            }
            System.out.println(unique);
        }
    }
}
