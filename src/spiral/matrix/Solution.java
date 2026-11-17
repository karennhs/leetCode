package spiral.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Test Result
 * 54. Spiral Matrix
 * Medium
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * Hint 1
 * Well for some problems, the best way really is to come up with some algorithms for simulation. Basically, you need to simulate what the problem asks us to do.
 * Hint 2
 * We go boundary by boundary and move inwards. That is the essential operation. First row, last column, last row, first column, and then we move inwards by 1 and repeat. That's all. That is all the simulation that we need.
 * Hint 3
 * Think about when you want to switch the progress on one of the indexes. If you progress on i out of [i, j], you'll shift in the same column. Similarly, by changing values for j, you'd be shifting in the same row. Also, keep track of the end of a boundary so that you can move inwards and then keep repeating. It's always best to simulate edge cases like a single column or a single row to see if anything breaks or not.
 */
enum Direction {
    RIGHT, LEFT, UP, DOWN;
}

public class Solution {

    void main() {
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};

        IO.println("solution:" + spiralOrder(matrix));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int maxRow = matrix.length - 1;
        int minRow = 0;
        // int currCol = matrix[0].length - 1;
        int maxCol = matrix[0].length - 1;
        int minCol = 0;
        int i = 0;
        int j = 0;
        boolean rowCompleted;
        int matrixSize = matrix.length * matrix[0].length;
        Direction direction = Direction.RIGHT;

        while (spiral.size() < matrixSize) {

            spiral.add(matrix[i][j]);

            if (i == minRow && j == maxCol && Direction.RIGHT.equals(direction)) {
                minRow++;
                direction = Direction.DOWN;
            } else if (i == maxRow && j == maxCol && Direction.DOWN.equals(direction)) {
                maxCol--;
                direction = Direction.LEFT;
            } else if (j == minCol && i == maxRow && Direction.LEFT.equals(direction)) {
                maxRow--;
                direction = Direction.UP;
            } else if (i == minRow && j == minCol && Direction.UP.equals(direction)) {
                minCol++;
                direction = Direction.RIGHT;
            }

            if (i == minRow && j < maxCol && Direction.RIGHT.equals(direction)) {
                j++;
            } else if (i < maxRow && j == maxCol && Direction.DOWN.equals(direction)) {
                i++;
            } else if (i == maxRow && minCol != j && Direction.LEFT.equals(direction)) {
                j--;
            } else if (minRow < i) {
                i--;
            }


        }

        return spiral;
    }
}