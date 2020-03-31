import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {

    /**
     * n = 10
     * m = 3
     * <p>
     * a b k
     * 1 5 3
     * 4 8 7
     * 6 9 1
     */

    public static void main(String[] args) {

        long max = 0;
        int n = 10;
        int m = 3;
        int[] row = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[][] queries = new int[][]{{1, 5, 3}, {4, 8, 7}, {6, 9, 1}};

        List<int[]> rowList = new ArrayList<>();
        rowList.add(row);
        int[] tempRow = Arrays.copyOf(row, row.length);

        for (int[] query : queries) {
            int a, b, k;
            a = b = k = 0;

            for (int j = 0; j < query.length; j++) {
                switch (j) {
                    case 0:
                        a = query[j];
                        break;
                    case 1:
                        b = query[j];
                        break;
                    case 2:
                        k = query[j];
                }
            }
            for (int i1 = a - 1; i1 < b; i1++) {
                tempRow[i1] = tempRow[i1] + k;
                if (tempRow[i1] > max) max = tempRow[i1];
            }
            rowList.add(tempRow);
            tempRow = tempRow.clone();
        }

        printArraysFromList(rowList);
        System.out.println(max);
    }

    private static void print1DArray(int[] a) {
        for (int i : a) {
            System.out.print(String.valueOf(i).concat(" "));
        }
        System.out.println();
    }

    private static void print2DArray(int[][] a) {
        for (int[] query : a) {
            print1DArray(query);
        }
    }

    private static void printArraysFromList(List<int[]> list) {
        for (int[] ints : list) {
            print1DArray(ints);
        }
    }
}
