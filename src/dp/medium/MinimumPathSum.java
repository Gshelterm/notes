package dp.medium;

/**
 * leetcode #64
 *
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] test = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(test));
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n <= 0) return 0;
        int[][] state = new int[n][m];
        state[0][0] = grid[0][0];

        for (int j = 1; j < m; j++) {
            state[0][j] = state[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            state[i][0] = state[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                state[i][j] = Math.min(state[i-1][j], state[i][j-1]) + grid[i][j];
            }
        }

        return state[n-1][m-1];
    }
}
