package Arrays;

import java.util.ArrayList;

public class SpiralOrderMatrix {

    private static int addUpperL(int startRow, int endColumn, int startColumn, int endRow, int[][] spiral, int start) {
        if (startColumn<=endColumn) {
            for (int i = startColumn; i <= endColumn; i++) {
                spiral[startRow][i] = start;
                start++;
            }
        }
        if(startRow+1<=endRow){
            for (int i = startRow + 1; i <= endRow; i++) {
                spiral[i][endColumn] = start;
                start++;

            }
        }

        return start;
    }

    private static int addLowerL(int startRow, int endColumn, int startColumn, int endRow, int[][] spiral, int start) {
        if(startColumn>=endColumn) {
            for (int i = startColumn; i >= endColumn; i--) {
                spiral[startRow][i] = start;
                start++;
            }
        }

        if(startRow-1>=endRow) {
            for (int i = startRow - 1; i >= endRow; i--) {
                spiral[i][endColumn] = start;
                start++;

            }
        }

        return start;

    }


    public static int[][] generateMatrix(int A) {

        int[][] data = new int[A][A];
        int squareA = A * A;
        int startRow = 0;
        int startColumn = 0;
        int endRow = A-1;
        int endColumn = A-1;
        int start = 1;

        while (startRow <= endRow && endColumn >= startColumn) {
            start = addUpperL(startRow, endColumn, startColumn, endRow, data, start);
            start = addLowerL(endRow, startColumn, endColumn - 1, startRow + 1, data, start);
            startRow = startRow + 1;
            startColumn = startColumn + 1;
            endColumn = endColumn - 1;
            endRow = endRow - 1;
        }

       // data[startRow][startColumn] = start;

        return data;
    }

    private static void print2dmat(int[][] data) {
        for (int rows = 0; rows < data.length; rows++) {
            for (int cols = 0; cols < data[rows].length; cols++) {
                System.out.print(" " + data[rows][cols]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
       /* int[][] data = new int[][]{{1,2,3},{4},{5,6,7}};
        print2dmat(data);*/

        int a = 10;

        print2dmat(generateMatrix(a));
    }

}
