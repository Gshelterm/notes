package dp.basic;

/**
 *
 */
public class UglyNumberNth {
    public static void main(String[] args) {
        System.out.println(getUglyNumberNth(10));
    }

    public static int getUglyNumberNth(int n) {
        int[] ugly = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = 1;
        int nextMultipleI2 = ugly[i2] * 2;
        int nextMultipleI3 = ugly[i3] * 3;
        int nextMultipleI5 = ugly[i5] * 5;
        int nextUglyNumber = 1;

        for (int i = 1; i < n; i++) {
            nextUglyNumber = Math.min(Math.min(nextMultipleI2, nextMultipleI3), nextMultipleI5);
            ugly[i] = nextUglyNumber;

            if (nextUglyNumber == nextMultipleI2) {
                i2 += 1;
                nextMultipleI2 = ugly[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleI3) {
                i3 += 1;
                nextMultipleI3 = ugly[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleI5) {
                i5 += 1;
                nextMultipleI5 = ugly[i5] * 5;
            }
        }

        return ugly[n-1];
    }


    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int t2 = 0, t3 = 0, t5 = 0;

        while (nextUglyIndex < index) {
            int nextUglyNumber = Math.min(Math.min(uglyNumbers[t2] * 2, uglyNumbers[t3] * 3), uglyNumbers[t5] * 5);
            uglyNumbers[nextUglyIndex] = nextUglyNumber;

            while (uglyNumbers[t2] * 2 <= nextUglyNumber) {
                t2++;
            }
            while (uglyNumbers[t3] * 3 <= nextUglyNumber) {
                t3++;
            }
            while (uglyNumbers[t5] * 5 <= nextUglyNumber) {
                t5++;
            }
            nextUglyIndex++;
        }

        return uglyNumbers[index-1];
    }
}
