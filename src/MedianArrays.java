import java.util.Arrays;

public class MedianArrays {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int[][][] nums = {{{1, 3}, {2}}, {{1, 2}, {3, 4}}, {{1, 3}, {2, 7}}};
        for (int[][] num : nums) {
            result.append(findMedianSortedArrays(num[0], num[1])).append(" ");
        }
        System.out.println(result);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);

        int length = merged.length;
        if (length % 2 == 1) {
            return merged[length / 2];
        } else {
            int leftMiddle = merged[length / 2 - 1];
            int rightMiddle = merged[length / 2];
            return ((double) (leftMiddle + rightMiddle)) / 2;
        }
    }

}
