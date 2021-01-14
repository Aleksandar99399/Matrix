package Matrix.oop;

/**
 * Matrix class contains Brick 2D array
 * Constructor accept 2 variables:
 * Rows and cols from the input.
 */
public class Matrix {

    private Brick[][] matrix;

    public Matrix(int rows, int cols) {
        this.matrix = new Brick[rows][cols];

    }

    public Brick[][] getMatrix() {
        return matrix;
    }

    public Matrix setMatrix(Brick[][] matrix) {
        this.matrix = matrix;
        return this;
    }
}

