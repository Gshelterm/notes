package dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * # 120
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 */
public class TriangleMinimumPath {
    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(Arrays.asList(-1));
        test.add(Arrays.asList(3,2));
        test.add(Arrays.asList(-3,1,-1));
        System.out.println(minimumTotalV2(test));
    }

    /**
     * top - down method
     * @param triangle
     * @return
     */
    public static int minimumTotalV2(List<List<Integer>> triangle) {
        int n = 0;
        if (triangle == null ||(n = triangle.size()) == 0) return 0;

        int[] curRow = {triangle.get(0).get(0)};
        for (int i = 1; i < n; i++) {
            int cols = triangle.get(i).size();
            int[] nextRow = new int[cols];
            for (int j = 0; j < cols; j++) {
                if (j == 0) nextRow[j] = curRow[j] + triangle.get(i).get(j);
                else if (j == cols-1) nextRow[j] = curRow[j-1] + triangle.get(i).get(j);
                else nextRow[j] = Math.min(curRow[j-1], curRow[j]) + triangle.get(i).get(j);
            }
            curRow = nextRow;
        }

        int res = Integer.MAX_VALUE;
        for (int a : curRow) {
            if (a < res) res = a;
        }
        return res;
        // 为什么流很慢
//        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }

    /**
     * bottom -up method
     */
    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        int s = triangle.size() - 1;
        int bottomRowSize = triangle.get(s).size() - 1;

        if(triangle == null || triangle.size() < 1) return 0;
        if(triangle.size() == 1) return triangle.get(s).get(0);

        int[] row = new int[triangle.get(s).size()];
        for(int i = 0; i < row.length; i++)
            row[i] = triangle.get(s).get(i);

        for(int i = s - 1; i >= 0; i--) {
            List<Integer> l = triangle.get(i);
            for(int j = 0; j < l.size(); j++) {
                row[j] = l.get(j) + Math.min(row[j], row[j + 1]);
            }
        }
        return row[0];
    }

    public int minimumTotalV1(List<List<Integer>> triangle) {
        int n = 0;
        if (triangle == null ||(n = triangle.size()) == 0) return 0;
        int m = triangle.get(n-1).size();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }
        matrix[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0, len = triangle.get(i).size(); j < len; j++) {
                if (j == 0) matrix[i][j] = matrix[i-1][j] + triangle.get(i).get(j);
                else if (j == len-1) matrix[i][j] = matrix[i-1][j-1] + triangle.get(i).get(j);
                else {
                    matrix[i][j] = Math.min(matrix[i-1][j-1], matrix[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int a : matrix[n-1]) {
            if (a < res) res = a;
        }
        return res;
//        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }
}
