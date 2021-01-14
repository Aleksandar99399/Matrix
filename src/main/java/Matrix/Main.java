package Matrix;

import Matrix.oop.Brick;
import Matrix.oop.Matrix;
import Matrix.oop.Methods;
import Matrix.oop.Reader;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        Reader rd = new Reader();

        String[] rowsAndCols = rd.readLine().split("\\s+");
        int rows;
        int cols;

        try {
            rows = Integer.parseInt(rowsAndCols[0]);
            cols = Integer.parseInt(rowsAndCols[1]);
            Methods.validateInput(rows, cols);

        }catch (NumberFormatException ne){
            throw new NumberFormatException("Invalid input. Try again!");

        }catch (IllegalArgumentException ie){
            ie.printStackTrace();
            return;
        }

        Matrix matrix = new Matrix(rows, cols);

        for (int i = 0; i < matrix.getMatrix().length; i++) {
            int[] numbers = Arrays.stream(rd.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < matrix.getMatrix()[i].length; j++) {
                Brick brick = new Brick(numbers[j]);
                matrix.getMatrix()[i][j] = brick;
            }
        }

        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[i].length; j++) {

                Brick firstHalf = matrix.getMatrix()[i][j];

                if (Methods.boundIndexes(matrix.getMatrix(), i, j + 1)
                        && firstHalf.getValue() == matrix.getMatrix()[i][j + 1].getValue()) {

                    Brick downValue = matrix.getMatrix()[i + 1][j];
                    matrix.getMatrix()[i + 1][j] = firstHalf;
                    matrix.getMatrix()[i][j + 1] = downValue;
                    j++;

                } else if (Methods.boundIndexes(matrix.getMatrix(), i + 1, j)
                        && firstHalf.getValue() == matrix.getMatrix()[i + 1][j].getValue()) {

                    Brick rightValue = matrix.getMatrix()[i][j + 1];
                    matrix.getMatrix()[i][j + 1] = firstHalf;
                    matrix.getMatrix()[i + 1][j] = rightValue;
                    j++;

                } else {
                    throw new IndexOutOfBoundsException("Index is out of bounds.\nTry again!");
                }
            }
            i++;
        }
        Methods.printMatrix(matrix);
    }


}