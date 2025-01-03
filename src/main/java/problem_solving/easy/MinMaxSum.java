package problem_solving.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        arr.sort(Comparator.comparingInt(Integer::intValue));
        int minVal = 0;
        int maxVal = 0;
        int i = 0;
        while (i < arr.size() - 1) {
            minVal += arr.get(i);
            i++;
            maxVal += arr.get(i);
        }
        System.out.println(minVal + " " + maxVal);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 2, 3, 4, 10);
        int asInt = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        long count = list.stream().filter(x -> x == asInt).count();
        miniMaxSum(list);

    }

}
