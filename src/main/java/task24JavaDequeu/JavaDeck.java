package task24JavaDequeu;
//https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true

import java.util.*;

public class JavaDeck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxNumbers = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);
            if (deque.size() == m) {
                if (set.size() > maxNumbers) {
                    maxNumbers = set.size();
                }
                int firstInSubArray = (int) deque.removeFirst();
                if (!deque.contains(firstInSubArray)) {
                    set.remove(firstInSubArray);
                }
            }
        }
        System.out.println(maxNumbers);
    }

    public static int slowUniqueMaxNumbers(int sizeSubArray, Deque deque) {
        int max = 0;
        int size = deque.size();
        Set<Integer> currentSubArraySet = new HashSet<>();
        List<Integer> copyDeque = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            copyDeque.add((Integer) deque.removeFirst());
        }
        for (int k = 0; k <= size - sizeSubArray; k++) {
            for (int j = k; j < k + sizeSubArray; j++) {
                Integer integer = copyDeque.get(j);
                currentSubArraySet.add(integer);
                if (j == k + sizeSubArray - 1) {
                    int currentSize = currentSubArraySet.size();
                    if (currentSize > max) {
                        max = currentSize;
                    }
                    currentSubArraySet = new HashSet<>();
                }

            }
        }
        return max;
    }
}
