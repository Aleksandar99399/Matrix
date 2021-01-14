package Matrix.oop;


/**
 * Methods class contains all static methods
 * needs for proper execution.
 */
public class Methods {

    /**
     * Method validate:
     * @param rows from input
     * @param cols from input
     *
     * Throw exception if input is with invalid arguments
     */
    public static void validateInput(int rows, int cols) {

        if (rows % 2 != 0 || rows >= 100 || cols >= 100 || cols % 2 != 0) {
            throw new IllegalArgumentException("-1: Solutions not exist!");
        }
    }

    /**
     * Method print the 2D array.
     * @param matrix contains inside this one.
     */
    public static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[i].length; j++) {
                System.out.print(matrix.getMatrix()[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Method checks whether given row and column is in the range on 2D array
     */
    public static boolean boundIndexes(Brick[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c < matrix[r].length && c >= 0;
    }
}
