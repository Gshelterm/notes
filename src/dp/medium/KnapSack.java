package dp.medium;


public class KnapSack {
    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        System.out.println(knapStackV2(50, wt, val, wt.length));
    }

    /**
     * 关键是找到其最优子结构，包括或不包括nth项
     */
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        if (W == 0 || n == 0) return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > W) return knapSack(W, wt, val, n-1);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else return Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                knapSack(W, wt, val, n-1));
    }

    public static int knapStackV2(int W, int[] wt, int[] val, int n) {

        int[][] K = new int[n+1][W+1];
        for (int j = 0; j <= W; j++) {
            K[0][j] = 0;
        }
        for (int k = 0; k <= n; k++) {
            K[k][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (w >= wt[i-1]) {
                    K[i][w] = Math.max(K[i-1][w], val[i-1] + K[i-1][w-wt[i-1]]);
                }
                else K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }
}
