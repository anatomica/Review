import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicates {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int[][] nums = {{1, 1, 2}, {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, {-3, -1, 0, 0, 0, 3, 3}};
        for (int[] num : nums) {
            result.append(removeDuplicates(num)).append(" ");
        }
        System.out.println(result);
    }

    private static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }

        int count = 0;
        for (int key : map.keySet()) {
            nums[count] = key;
            count++;
        }

        return map.size();
    }

}
