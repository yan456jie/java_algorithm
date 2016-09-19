package dynamicProgramming;
/*
从左上角走到右下角最小步数
0,0,0,0,0
0,1,2,1,3
0,1,1,1,1
0,2,3,2,1
0,1,2,2,1
 */
public class DynamicPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] steps = {{0,0,0,0,0},{0,1,2,1,3},{0,1,1,1,1},{0,2,3,2,1},{0,1,2,2,1}};
		int min = getMin(steps);
		System.out.println(min);
	}
	public static int getMin(int[][] steps) {
        if (steps == null || steps.length == 0 || steps[0] == null || steps[0].length == 0) {
            return 0;
        }

        int row = steps.length;
        int col = steps[0].length;

        int[][] matrix = new int[row][col];
        matrix[0][0] = steps[0][0];
        for (int i = 1; i < row; i++) {
            matrix[i][0] = matrix[i - 1][0] + steps[i][0];
        }
        for (int j = 1; j < col; j++) {
            matrix[0][j] = matrix[0][j - 1] + steps[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] = Math.min(matrix[i - 1][j] + steps[i][j], matrix[i][j - 1]) + steps[i][j];
            }
        }
        printMatrix(matrix);
        return matrix[row - 1][col - 1];
    }
	
	public static void printMatrix(int[][] matrix) {
		int row = matrix.length;
        int col = matrix[0].length;
		for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
            	System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
	}
}
