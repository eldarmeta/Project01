
package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;

        // Разбиваем массив на две части
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Рекурсивно сортируем обе части
        mergeSort(left);
        mergeSort(right);

        // Сливаем две отсортированные части
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Сравниваем элементы из left и right и заполняем arr
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }

        // Добавляем оставшиеся элементы
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 6, 3};

        System.out.println("Before sorting: " + Arrays.toString(numbers));
        mergeSort(numbers);
        System.out.println("After sorting:  " + Arrays.toString(numbers));
    }
}
