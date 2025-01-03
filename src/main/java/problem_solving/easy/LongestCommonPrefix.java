package problem_solving.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                if (prefix.isEmpty()) {
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"abc", "oabcd", "abccc"});
        System.out.println(s);
    }
}
