import java.util.Arrays;

public class MinimumMoves {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int[][] nums = {{1, 2, 3}, {1, 10, 2, 9}, {1, 10, 1, 15}, {1, 0, 0, 8, 6}, {1, 2, 5, 8, 0}, {3, 0, 6, 2, 4, 7, 0, 0}};
        for (int[] num : nums) {
            result.append(minMoves2(num)).append(" ");
        }
        System.out.println(result);
    }

    public static int minMoves2(int[] nums) {
        int length = nums.length;
        int result = 0;
        int median = helper(nums, 0, length - 1, (length - 1) / 2);
        for (int x : nums) {
            result += Math.abs(x - median);
        }
        return result;
    }

    private static int helper(int[] q, int l, int r, int k) {
        if (l >= r) return q[r];
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        if (k <= j) {
            return helper(q, l, j, k);
        }
        return helper(q, j + 1, r, k);
    }

    public static int minMoves3(int[] nums) {
        Arrays.sort(nums);
        int mediana = nums[nums.length / 2];

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > mediana) {
                nums[i]--;
                count++;
            }
            while (nums[i] < mediana) {
                nums[i]++;
                count++;
            }
        }
        return count;
    }

}
