package dp.hard;

/**
 *  https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 *
 * Input  : abbc
 * Output : 3
 * Subsequences are abc, abc and abbc
 *
 * Input  : abcabc
 * Output : 7
 * Subsequences are abc, abc, abbc, aabc
 * abcc, abc and abc
 */
public class NumberOfSubSequencesaibjck {

    public static int countSubsequences(String str) {
        // Initialize counts of different subsequences
        // caused by different combination of 'a'
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        int len  = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'a') {
                aCount = 1 + 2 * aCount;
            }
            /** If current character is 'b', then
               there are following possibilities :
                 a) Current character begins a new
                    subsequence of b's with aCount
                    subsequences.
                 b) Current character is part of bCount
                    subsequences.
                 c) Current character is not part of
                    bCount subsequences. **/
            else if (str.charAt(i) == 'b') {
                bCount = aCount + 2 * bCount;
            }
            else if (str.charAt(i) == 'c') {
                cCount = bCount + 2 * cCount;
            }
        }

        return cCount;
    }

    public static void main(String[] args) {
        System.out.println(countSubsequences("abcabc"));
    }
}
