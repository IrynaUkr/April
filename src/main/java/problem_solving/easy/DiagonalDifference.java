package problem_solving.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        //find diagonal sum from left up to right down
        int downDiagonalSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            downDiagonalSum += arr.get(i).get(i);
        }
        //find diagonal sum from left down to right up
        int upDiagonalSum = 0;
        int rowIndex = 0;
        int columnIndex = arr.size() - 1;
        while (rowIndex < arr.size()) {
            upDiagonalSum += arr.get(columnIndex).get(rowIndex);
            columnIndex--;
            rowIndex++;
        }
        return Math.abs(upDiagonalSum - downDiagonalSum);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(11, 2, 4));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(10, 8, -12));
        diagonalDifference(arr);
        int num = 5;
        double dd = num / 3;


    }

}
