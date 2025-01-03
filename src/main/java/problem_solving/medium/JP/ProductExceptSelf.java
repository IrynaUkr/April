package problem_solving.medium.JP;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i <nums.length; i++) {
            result[i]= prefix[i]* suffix[i];
        }
        return result;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{-1,1,0,-3,3});
        //Output: [24,12,8,6]
        //Output: [0,0,9,0,0]
    }

}
