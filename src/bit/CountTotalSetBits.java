package bit;

/**
 * todo：补充注释
 *
 * @author gouguokun by 2018-08-01 11:10
 * @since 1.0
 */
public class CountTotalSetBits {

    public static int count(int n) {

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += countSetBitsUtil(i);
        }
        return total;
    }

    // util function
    public static int countSetBitsUtil(int num) {
        if (num <= 0) return 0;
        else return ((num & 1) == 0 ? 0 : 1) + countSetBitsUtil(num >> 1);
    }

    public static int[] countBitsV2(int num) {
        int[] numOfBits = new int[num+1];
        for (int i = 1; i <= num; i++) {
            numOfBits[i] = numOfBits[i >> 1] + (i & 1);
        }
        return numOfBits;
    }

    public static void main(String[] args) {
//        System.out.println((3 >> 1) + (3 & 1));
         System.out.println(countBitsV2(5));
    }
}
