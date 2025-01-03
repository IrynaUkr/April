package problem_solving.easy;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        int positiveCounter = 0;
        int negativeCounter = 0;
        int zeroCounter = 0;
        for (Integer number : arr) {
            if (number > 0) {
                positiveCounter++;
            } else if (number < 0) {
                negativeCounter++;
            } else {
                zeroCounter++;
            }
        }
        double positive = (double) positiveCounter / arr.size();
        System.out.printf("%.6g%n", positive);
        double negative = (double) negativeCounter / arr.size();
        System.out.printf("%.6g%n",negative);
        double zero = (double) zeroCounter / arr.size();
        System.out.printf("%.6g%n", zero);

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 0, -1, -2);
        plusMinus(list);

    }

}
