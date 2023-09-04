import java.util.HashMap;
import java.util.Map;

public class Unique {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, -7, -7, -7, 1, 2, 5, 3, 1, 2};
        int n = getFirstUnique(arr);
        System.out.println("Найдено уникальное значение " + n);
    }

    private static int getFirstUnique(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            int count = map.getOrDefault(value, 0);
            count++;
            map.put(value, count);
        }

        for (int value : arr) {
            if (1 == map.get(value)) {
                return value;
            }
        }

        throw new RuntimeException("Ошибка поиска элемента!");
    }

}
