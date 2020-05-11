public class Matrix {

    private int[] arr;

    public Matrix(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public Matrix(int[] arr) {
        this.arr = arr;
    }

    public int root(int i) {
        while (i != arr[i]) i = arr[i];
        return i;
    }

    public int[] getArr() {
        return arr;
    }
}
