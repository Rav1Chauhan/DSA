class Solution {

    public void setZeroes(int[][] matrix) {

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        findZero(0, 0, matrix, rows, cols);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void findZero(
        int i,
        int j,
        int[][] matrix,
        boolean[] rows,
        boolean[] cols
    ) {

        if (i == matrix.length)
            return;

        if (j == matrix[0].length) {
            findZero(i + 1, 0, matrix, rows, cols);
            return;
        }

        if (matrix[i][j] == 0) {
            rows[i] = true;
            cols[j] = true;
        }

        findZero(i, j + 1, matrix, rows, cols);
    }
}