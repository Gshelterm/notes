package dp.medium;

public class LongestIncreasingSubsequence {
    private int res = 0;

    public static void main(String[] args) {
        int[] arr =  {3, 10, 2, 1, 20};
        System.out.println(lengthOfLIS(arr));
    }

    /**
     * O(n^2)解法，还有O(nlogn)解法
     */
    public static int lengthOfLIS(int[] nums) {
        int len;
        if ((len = nums.length) == 0) return 0;
        if (len == 1) return 1;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j]+1)
                    dp[i] = dp[j]+1;
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(dp[i], res);
        }

        return res;
    }

}
