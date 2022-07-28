package task22JavaStack;

//https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

    public static void main(String[] argh) {
        List<Integer> array= new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isStringBalanced(input));
        }
        sc.close();
    }

    public static boolean isStringBalanced(String input) {
        Stack<Character> ch = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char head = input.charAt(i);
            if (head == '{' || head == '(' || head == '[') {
                ch.push(head);
            } else {
                if (ch.empty()) {
                    return false;
                } else {
                    Character tail = ch.pop();
                    if ((tail == '(' && head != ')')
                            || (tail == '{' && head != '}')
                            || (tail == '[' && head != ']')) {
                        return false;

                    }
                }
            }
        }

        return ch.isEmpty();
    }


}