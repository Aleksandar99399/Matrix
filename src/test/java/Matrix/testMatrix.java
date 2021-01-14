package Matrix;

import Matrix.oop.Matrix;
import Matrix.oop.Methods;
import org.junit.Assert;
import org.junit.Test;

public class testMatrix {

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputForRowsAndCols(){
        Methods.validateInput(100,100);
    }

    @Test
    public void testMatricesNotEqual(){
        Matrix matrix = new Matrix(4,4);
        Assert.assertNotNull(matrix.getMatrix());
    }

}
