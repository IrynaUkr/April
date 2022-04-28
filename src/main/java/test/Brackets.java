package test;

import java.util.LinkedList;
import java.util.Stack;

public class Brackets {
    static String isBalanced(String s) {
        Stack<Character> openBracketsList = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                openBracketsList.push(s.charAt(i));
                System.out.println(openBracketsList);

            } else {
                if (openBracketsList.isEmpty()) {
                    return "NO";
                } else {
                    char last = openBracketsList.pop();
                    System.out.println(last);
                    if (s.charAt(i) == '}' && last != '{') {
                        return "NO";
                    } else if (s.charAt(i) == ']' && last != '[') {
                        return "NO";
                    } else if (s.charAt(i) == ')' && last != '(') {
                        return "NO";
                    }
                }
            }
        }
        if (openBracketsList.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }


    public static void main(String[] args) {
        System.out.println(isBalanced("{}(){}}"));
    }

}
