package bit;

/**
 * https://www.geeksforgeeks.org/highest-power-2-less-equal-given-number/
 * A selection process follows a rule where people standing on even positions are selected.
 */
public class HighestPowerOf2LessThanN {
    public static int highestPowerof2(int n) {
        if (n <= 0) return -1;
        for (int i = n; i >= 1; i--) {
            if (isPowerOfTwo(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int highestPowerof2V2(int n)
    {
        // Invalid input
        if (n < 1)
            return 0;

        int res = 1;

        // Try all powers
        // starting from 2^1
        for (int i = 0; i < 8 ; i++)
        {
            int curr = 1 << i;

            // If current power is
            // more than n, break
            if (curr > n)
                break;

            res = curr;
        }

        return res;
    }

    /**
     * use Log
     */
    static int highestPowerof2V3(int n)
    {

        int p = (int)(Math.log(n) /
                Math.log(2));
        return (int)Math.pow(2, p);
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & n-1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(highestPowerof2(31));
    }
}
