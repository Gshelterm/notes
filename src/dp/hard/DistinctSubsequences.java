package dp.hard;

/**
 * #115
 * https://leetcode.com/problems/distinct-subsequences/description/
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        String a = "";
        String b = "a";
        System.out.println(numDistinct(a, b));
    }

    /**
     * what's its overlapping subproblems?
     * what's its optimal structure
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        return numDistinctDynamicV2(s, t, s.length(), t.length());
    }

    public static int numDistinctNaive(String s, String t, int m, int n) {
        if (n == 0) return 1;   // n==0 的判断在先
        if (m == 0) return 0;

        if (s.charAt(m-1) != t.charAt(n-1)) {
            return numDistinctNaive(s, t, m-1, n);
        }
        else {
            return numDistinctNaive(s, t, m-1, n-1) +
                    numDistinctNaive(s, t, m-1, n);
        }
    }

    public static int numDistinctDynamic(String s, String t, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = 0;

                else if (s.charAt(i-1) != t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 二维转一维
     */
    public static int numDistinctDynamicV2(String s, String t, int m, int n) {
        int[] dpCur = new int[n+1];
        int[] dpNext;

        for (int i = 0; i <= n; i++) {
            dpCur[i] = 0;
        }
        dpCur[0] = 1;
        for (int i = 1; i <= m; i++) {
            dpNext = new int[n+1];
            for (int j = 0; j <= n; j++) {
                if (j == 0) dpNext[j] = 1;

                else if (s.charAt(i-1) != t.charAt(j-1)) {
                    dpNext[j] = dpCur[j];
                }
                else {
                    dpNext[j] = dpCur[j-1] + dpCur[j];
                }
            }
            dpCur = dpNext;
        }
        return dpCur[n];
    }
}
