package problem_solving.medium.JP;

public class ReverseAndPalindrome {
    //Given an integer, add it with the reverse of the value, and check if it’s a palindrome.
    // If it isn’t a palindrome, repeat the process until the sum is a palindrome.
    // Print out the number of iterations and the value of the final palindrome.
    // If it took more than 1, 000 iterations (additions)
    // or yield a palindrome that is greater than 4, 294, 967, 295, assume that no palindrome exist
    // for the given number.
    public static long makePalindrome(int num) {
        long barrier = 4294967295L;
        while (num < barrier) {
            long reversedNumber = reverse(num);
            num += reversedNumber;
            if (isPalindrome(num)) {
                return num;
            }
        }
        return -1;
    }

    public static long reverse(long input) {
        boolean positiveSign = input > 0;
        long res = 0;
        input = Math.abs(input);
        while (input > 0) {
            long lastSymbol = input % 10;
            res = res * 10 + lastSymbol;
            input = input / 10;
        }
        return res;
    }

    public static boolean isPalindrome(long input) {
        return Math.abs(input) == reverse(input);
    }


    public static void main(String[] args) {
        String s = gcdOfStrings2("ABABABAB", "ABAB");
        System.out.println(s);

    }

    public static String gcdOfStrings(String str1, String str2) {
        String small = str1.length() <= str2.length() ? str1 : str2;
        String big = str1.length() > str2.length() ? str1 : str2;
        if (big.matches(String.format("(%s)+", small))) {
            return small;
        }

        StringBuilder prefix = new StringBuilder();
        char first = small.charAt(0);
        prefix.append(first);
        for (int i = 1; i < small.length(); i++) {
            if (first != small.charAt(i)) {
                prefix.append(small.charAt(i));
            } else {
                //check if small string can be devided without reminder by prefix
                int prefixLength = prefix.length();
                if (small.length() % prefixLength == 0) {
                    //check if prefix is  devider
                    String currentRegex = String.format("(%s)+", prefix);
                    if (small.matches(currentRegex) && big.matches(currentRegex)) {
                        //divisor found
                        return prefix.toString();
                    } else {
                        prefix.append(small.charAt(i));
                    }
                } else {
                    prefix.append(small.charAt(i));
                }

            }
        }
        return "";
    }


    public static String gcdOfStrings2(String str1, String str2) {
        String small = str1.length() <= str2.length() ? str1 : str2;
        String big = str1.length() > str2.length() ? str1 : str2;
        if (big.matches(String.format("(%s)+", small))) {
            return small;
        }
        String prefix;
        for (int i = 2; i < small.length(); i++) {
            if (small.length() % i == 0) {
                prefix = small.substring(0, small.length() / i);
                String currentRegex = String.format("(%s)+", prefix);
                if (small.matches(currentRegex) && big.matches(currentRegex)) {
                    return prefix.toString();
                }
            }
        }
        return "";
    }
}