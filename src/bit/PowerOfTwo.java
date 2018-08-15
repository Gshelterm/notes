package bit;

/**
 *
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        while (n > 0) {
            if ((n & 1) == 0) n >>= 1;
            else if (n == 1) return true;
            else return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(218));
    }

}
