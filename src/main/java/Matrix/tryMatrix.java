package Matrix;

import Matrix.oop.Brick;
import Matrix.oop.Matrix;
import Matrix.oop.Methods;
import Matrix.oop.Reader;

import java.io.IOException;
import java.util.Arrays;


public class tryMatrix {
    public static void main(String[] args) throws IOException {

        Reader rd = new Reader();

        String[] rowsAndCols = rd.readLine().split("\\s+");
        int rows;
        int cols;

        try {
            rows = Integer.parseInt(rowsAndCols[0]);
            cols = Integer.parseInt(rowsAndCols[1]);
            Methods.validateInput(rows, cols, rowsAndCols.length);

        } catch (NumberFormatException ne) {
            throw new NumberFormatException("Invalid input. Try again!");

        } catch (IllegalArgumentException ie) {
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
            for (int j = 0; j < matrix.getMatrix()[i].length - 1; j++) {


                Brick upLeft = matrix.getMatrix()[i][j];
                Brick upRight = matrix.getMatrix()[i][j + 1];
                Brick downLeft = matrix.getMatrix()[i + 1][j];
                Brick downRight = matrix.getMatrix()[i + 1][j + 1];

                if (upLeft.getValue() == downLeft.getValue() && upRight.getValue() != downRight.getValue()) {
                    if (Methods.boundIndexes(matrix.getMatrix(), i, j + 2)
                            && matrix.getMatrix()[i][j + 3].getValue() == matrix.getMatrix()[i + 1][j + 3].getValue()) {

                        matrix.getMatrix()[i][j] = matrix.getMatrix()[i][j + 2];
                        matrix.getMatrix()[i + 1][j] = matrix.getMatrix()[i + 1][j + 1];
                        matrix.getMatrix()[i][j + 2] = upLeft;
                        matrix.getMatrix()[i + 1][j + 2] = downLeft;

                        j++;
                    }
                } else if (upLeft.getValue() == downLeft.getValue() && upRight.getValue() == downRight.getValue()) {
                    if (Methods.boundIndexes(matrix.getMatrix(), i, j + 1)
                            && upLeft.getValue() == matrix.getMatrix()[i][j + 1].getValue()) {

                        Brick downValue = matrix.getMatrix()[i + 1][j];
                        matrix.getMatrix()[i + 1][j] = upLeft;
                        matrix.getMatrix()[i][j + 1] = downValue;
                        j++;

                    } else if (Methods.boundIndexes(matrix.getMatrix(), i + 1, j)
                            && upLeft.getValue() == matrix.getMatrix()[i + 1][j].getValue()) {

                        matrix.getMatrix()[i][j] = matrix.getMatrix()[i][j - 2];
                        matrix.getMatrix()[i + 1][j] = matrix.getMatrix()[i + 1][j - 2];
                        matrix.getMatrix()[i][j - 2] = upLeft;
                        matrix.getMatrix()[i + 1][j - 2] = downLeft;
                        j++;

                    }
                } else if (upLeft.getValue()==upRight.getValue() && downLeft.getValue() ==downRight.getValue()){
                    Brick value = matrix.getMatrix()[i][j + 2];

                    if (value.getValue()== matrix.getMatrix()[i][j+3].getValue()){
                        matrix.getMatrix()[i][j+3] = matrix.getMatrix()[i+1][j+2];
                        matrix.getMatrix()[i+1][j+2] = value;
                    }else if (value.getValue() == matrix.getMatrix()[i+1][j+2].getValue()){

                    }

                    j++;
                }
                    Methods.printMatrix(matrix);
                System.out.println();

            }
            i++;
        }
    }


}