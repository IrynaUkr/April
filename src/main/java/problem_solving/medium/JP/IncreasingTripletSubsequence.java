package problem_solving.medium.JP;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= smallest) {
                smallest = num;
            } else if (num <= secondSmallest) {
                secondSmallest = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums1)); // Output: true

        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums2)); // Output: false

        int[] nums3 = {2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet(nums3)); // Output: true
    }

}

