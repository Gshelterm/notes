package dp.medium;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * partition to two subsets which sums equal
 */
public class PartitionProblem {
    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 9, 13};
        int n = arr.length;
        if (findPartitionDaynamic(arr) == true)
            System.out.println("Can be divided into two "+
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                    "two subsets of equal sum");
    }

    /**
     * recursion solution
     * Time Complexity: O(2^n) In worst case, this solution tries two possibilities (whether to include or exclude) for every element.
     */
    public static boolean findPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1) {
            // 奇数不可能划分
            return false;
        }

        return isSubsetSum(arr, n,sum/2);
    }

    /**
     * check whether can reach the sum
     * --recursive: reduce parameters scale
     */
    public static boolean isSubsetSum(int[] arr, int len, int sum) {
        if (sum == 0) return true;
        if (len == 0 && sum != 0) return false;

        if (arr[len-1] > sum)
            return isSubsetSum(arr, len-1, sum);
        return isSubsetSum(arr, len-1, sum-arr[len-1]) ||
                isSubsetSum(arr, len-1, sum);
    }

    /**
     * 当sum不是很大的时候，用动态规划解决
     * part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has sum
     *              equal to i, otherwise false
     */
    public static boolean findPartitionDaynamic(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1) {
            // 奇数不可能划分
            return false;
        }

        boolean part[][]=new boolean[sum/2+1][n+1];
        for (int i = 0; i <= n; i++) {
            part[0][i] = true;
        }
        for (int j = 0; j < sum/2; j++) {
            part[j][0] = false;
        }

        for (int i = 1; i <= sum/2; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[j-1] > i) part[i][j] = part[i][j-1];
                else part[i][j] = part[i][j-1] || part[i-arr[j-1]][j-1];
            }
        }
        return part[sum/2][n];
    }

    /**
     * 用深度优先遍历还更快？
     * 或的关系，只要有一边为true，则为true
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i :nums){
            sum +=i;
        }
        if(sum%2==1){
            return false;
        }
        return dfs(nums,sum/2,nums.length-1);
    }
    private boolean dfs(int[] nums, int target, int index){
        if(target == 0){
            return true;
        }
        if(index<0||target<0){
            return false;
        }
        if(dfs(nums,target-nums[index],index-1)){
            return true;
        }
        int j = index -1;
        while(j>=0&&nums[j]==nums[index]){
            j--;
        }
        return dfs(nums,target,j);
    }
}
