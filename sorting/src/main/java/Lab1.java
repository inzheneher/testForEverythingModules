import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Lab1 {
    /**
     * Sorting algorithms
     **/

    public static void main(String[] args) {
        int[] a = new int[]{7, 10, 0, 9, 3, 11, 2, 12, 8, 4, 1, 6, 5};
        System.out.println(Arrays.toString(a));
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static boolean less(int a, int b) {
        return a - b < 0;
    }

    // Swap two elements in an array
    private static void swap(@NotNull int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    // Selection sort.

    public static void selectionSort(@NotNull int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int minValue = array[minIndex];
            for (int j = i + 1; j < n; j++) {
                if (less(array[j], minValue)) {
                    minIndex = j;
                    minValue = array[minIndex];
                }
            }
            if (i != minIndex) swap(array, i, minIndex);
        }
    }

    // Insertion sort.

    public static void insertionSort(@NotNull int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1])) swap(array, j, j - 1);
                else break;
            }
        }
    }

    // Shell sort.

    public static void shellSort(@NotNull int[] array) {
        int n = array.length;
        int h = 1;
        while (h < (n - 1) / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = 0; i < h; i++) {
                for (int j = i; j < n; j += h) {
                    for (int k = j; k > i; k -= h) {
                        if (less(array[k], array[k - h])) swap(array, k, k - h);
                        else break;
                    }
                }
            }
            h = h / 3;
        }
    }

    // Quicksort.

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort part of an array
    private static void quickSort(int @NotNull [] array, int begin, int end) {
        int i, j, k;
        i = begin;
        j = end;
        k = array[(begin + end) / 2];
        do {
            while ((array[i] < k) && (i < end)) i++;
            while ((k < array[j]) && (j > begin)) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (begin < j) quickSort(array, begin, j);
        if (i < end) quickSort(array, i, end);
    }

    // Mergesort.

    public static int @NotNull [] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    // Mergesort part of an array
    private static int @NotNull [] mergeSort(int[] array, int begin, int end) {
        if (end <= begin) return new int[]{array[end]};
        int mid = begin + (end - begin) / 2;
        return merge(mergeSort(array, begin, mid), mergeSort(array, mid + 1, end));
    }

    // Merge two sorted arrays into one
    private static int @NotNull [] merge(int @NotNull [] left, int @NotNull [] right) {
        int resultLength = left.length + right.length;
        int lHi = left.length - 1, rHi = right.length - 1;
        int i, j;
        i = j = 0;
        int[] result = new int[resultLength];
        for (int k = 0; k < resultLength; k++) {
            if (i > lHi && j <= rHi) result[k] = right[j++];
            else if (j > rHi && i <= lHi) result[k] = left[i++];
            else if (less(left[i], right[j])) result[k] = left[i++];
            else result[k] = right[j++];
        }
        return result;
    }
}