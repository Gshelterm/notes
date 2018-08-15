package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 使用Factorial number system作为计数方式的基数。
 * https://ashprakasanblog.wordpress.com/2017/02/16/find-lexicographically-nth-permutation-of-an-ordered-string/
 * 不能处理重复字符情况
 */
public class NthPermutationFactorialNumberSystem {
    static int[] getFactoradic(int n, int len) {
        int[] factoradic = new int[len];
        int i = 1;
        while (n != 0) {
            factoradic[len - i] = n % i;
            n = n / i;
            i++;
        }
        return factoradic;
    }

    // function takes a String,str and Factoradic representation of a number n.
    // returns the nth lexicographic permutaion of character array, str.
    static String getPermutation(char[] str, int[] factoradic) {
        Arrays.sort(str);
        ArrayList<Character> res = new ArrayList<Character>();
        StringBuilder sb = new StringBuilder();
        int pos;
        char c;
        String perm = "";
        boolean[] used = new boolean[str.length]; // by default values are initialised to false.
        for (int i = 0; i < factoradic.length; i++) {
            pos = factoradic[i];
            c = getUnusedCharAtPos(str, pos, used);
            res.add(c);
        }
        for (char some_c : res) {
            sb.append(some_c);
        }
        return (sb.toString());
    }

    //function to get the yet unused character at a given position in a character array.
    private static char getUnusedCharAtPos(char[] str, int pos, boolean[] used) {
        int count = -1;
        for (int i = 0; i < str.length; i++) {
            if (!used[i]) {
                count++;
                if (count == pos) {
                    used[i] = true;
                    return str[i];
                }
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        int t, n, l;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        char[] str = "abcdefghijklm".toCharArray();
        int len = str.length;
        int[] f = new int[len];
        for (int i = 0; i < t; i++) {
            n = s.nextInt();
            f = getFactoradic(n-1, len);
            System.out.println(getPermutation(str, f));
        }

    }
}
