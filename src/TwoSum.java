import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int[][] nums = {{2, 7, 11, 15}, {3, 2, 4}, {3, 3}};
        int[] target = {9, 6, 6};
        for (int i = 0; i < nums.length; i++) {
            result.append(Arrays.toString(twoSum(nums[i], target[i]))).append(" ");
        }
        System.out.println(result);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};

                    }
                }
            }
        }
        return new int[]{0, 0};
    }

}
