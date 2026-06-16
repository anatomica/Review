public class MergeSortedArraysInPlace {

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        // Просто копируем все элементы
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        // Пузырьковая сортировка (простая, но неэффективная)
        bubbleSort(result);

        return result;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 10};
        int[] arr2 = {2, 5, 8, 11};

        int[] merged = merge(arr1, arr2);

        System.out.println("Объединенный массив после пузырьковой сортировки:");
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }
}
