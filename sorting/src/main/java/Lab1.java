import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Lab1 {
    /**
     * Sorting algorithms
     **/

    public static void main(String[] args) {
        int[] a = Bench.generateSample(100, 100);
        System.out.println(Arrays.toString(mergeSort(a)));
    }

    private static boolean less(int a, int b) {
        return a - b < 0;
    }

    private static void exchange(@NotNull int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
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
            if (i != minIndex) exchange(array, i, minIndex);
        }
    }

    // Insertion sort.

    public static void insertionSort(@NotNull int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1])) exchange(array, j, j - 1);
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
                        if (less(array[k], array[k - h])) exchange(array, k, k - h);
                        else break;
                    }
                }
            }
            h = h / 3;
        }
    }

    // Quicksort.

    public static void quickSort(int[] array) {
        throw new UnsupportedOperationException();
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
    }

    // Partition part of an array, and return the index where the pivot
    // ended up.
    private static int partition(int[] array, int begin, int end) {
        throw new UnsupportedOperationException();
    }

    // Swap two elements in an array
    private static void swap(@NotNull int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
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