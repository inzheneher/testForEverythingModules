import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MatrixTest {

    private Matrix matrix;

    @Before
    public void init() {
        matrix = new Matrix(new int[]{1, 2, 0, 6, 8, 9, 2, 5, 8, 7});
//        matrix = new Matrix(new int[]{1, 8, 1, 8, 3, 0, 5, 1, 8, 8});
    }

    @Test
    public void root() {
        System.out.println(Arrays.toString(matrix.getArr()));
        System.out.println(matrix.root(9));
    }
}