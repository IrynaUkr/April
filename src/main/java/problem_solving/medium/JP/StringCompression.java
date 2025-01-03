package problem_solving.medium.JP;

public class StringCompression {

    public static int compress(char[] chars) {
        int lastUpdatedIndex = 0;
        int repetitions = 1;

        for (int i = 0; i < chars.length; i++) {
            // Check if the current character is the last in its group
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                // Write the character
                chars[lastUpdatedIndex++] = chars[i];

                // Write the repetition count if greater than 1
                if (repetitions > 1) {
                    String count = String.valueOf(repetitions);
                    for (char c : count.toCharArray()) {
                        chars[lastUpdatedIndex++] = c;
                    }
                }

                // Reset repetitions for the next group
                repetitions = 1;
            } else {
                // Increment the repetition count for the current group
                repetitions++;
            }
        }

        // Return the new length
        return lastUpdatedIndex;
    }

    public static void main(String[] args) {
        int i = compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'});
        System.out.println(i);
    }

}
