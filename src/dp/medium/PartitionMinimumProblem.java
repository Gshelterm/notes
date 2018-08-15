package dp.medium;

/**
 * todo：补充注释
 */
public class PartitionMinimumProblem {

    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 6};
        System.out.print("The minimum difference"+
                " between two sets is " +
                findMin(arr));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return findMinPartition(nums, n, 0, sum);
    }

    /**
     * add element or not to set
     * 可以遍历所有可能
     * 时间复杂度: O(n^2)
     */
    public static int findMinPartition(int[] nums, int n, int sumCur, int sumTotal) {
        if (n == 0) return Math.abs(sumTotal-sumCur-sumCur);

        return Math.min(findMinPartition(nums, n-1, sumCur+nums[n-1], sumTotal),
                findMinPartition(nums, n-1, sumCur, sumTotal));
    }


    /**
     * dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+nums[i-1]])
     */
    public static int findMinDynamic(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int[][] dp = new int[n][sum/2+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = nums[i];
        }
        for (int j = 0; j <= sum/2+1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum/2+1; j++) {

            }
        }
        return 0;
    }


}
