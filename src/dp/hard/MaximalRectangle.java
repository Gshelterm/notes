package dp.hard;

/**
 * # 85
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] test = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        char[][] test2 = {{'1'}};
        System.out.println(maximalRectangle(test2));
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1:0;
                }
                else if (matrix[i][j] == '1') {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
                else dp[i][j] = 0;
            }
        }

        int max = 0, maxI = 0, maxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }


        int row = 0, col = 0;
        for(int i = maxI; i >= 0; i--)
        {
            for(int j = maxJ; j >= 0; j--)
            {
                if (dp[i][j] == 0) {
                    row = Math.min(row, i);
                    col = Math.min(col, j);
                }
            }
        }
        int res = (maxI-row) * (maxJ - col);
        return (res == 0) ? 1 : res;
    }

    public static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}
