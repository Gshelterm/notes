package dp.hard;

/**
 * todo：补充注释
 *
 * @author gouguokun by 2018-07-23 20:06
 * @since 1.0
 */
/* A naive recursive implementation that simply follows
   the above optimal substructure property */
class MatrixChainMultiplication
{
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k=i; k<j; k++)
        {
            int count = MatrixChainOrder(p, i, k) +
                    MatrixChainOrder(p, k+1, j) +
                    p[i-1]*p[k]*p[j];

            if (count < min)
                min = count;
        }

        // Return minimum count
        return min;
    }


    /**
     * dp
     * @param p Ai has demension p[i] * p[i-1]
     * @param n number of matrices
     * @return
     */
    public static int MatrixChainOrderDynamic(int p[], int n) {

        /**
         * matrix[i][j] multiplications of A[i]...A[j]
         */
        int[][] matrix = new int[n][n];

        for (int i = 1; i < n; i++) {
            matrix[i][i] = 0;
        }

        int i, j, k, L, q = 0;

//         L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                matrix[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = matrix[i][k] + matrix[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < matrix[i][j])
                        matrix[i][j] = q;
                }
            }
        }

        return matrix[1][n-1];
    }

    /**
     * Recursive Implementation
     * @param args
     *
     * Rec-Matrix-Chain(array p, int i, int j) {
     *       if (i = = j) m[i, i] = 0;                               // basic case
     *       else {
     *                   m[i, j] = infinity;                          // initialize
     *                   for k = i to j − 1 do {                   // try all possible splits
     *                            cost=Rec-Matrix-Chain(p, i, k) + Rec-Matrix-Chain(p, k + 1, j) + p[i − 1]*p[k]*p[j];
     *                            if (cost<m[i, j]) then
     *                                     m[i, j]= cost;
     *                            }
     *                    }                                               // update if better
     *        return m[i,j];                                          // return final cost
     * }
     */

    /**
     * n = j - i + 1;
     */
    static int[][] m;
    static {
        m = new int[5][5];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = -1;
            }
        }
    }
    public static int MatrixChainOrderMemoization(int[] p, int i, int j) {
        if (m[i][j] != -1) return m[i][j];
        else if (i == j) return m[i][j] = 0;
        else {
            m[i][j] = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                int cost = MatrixChainOrderMemoization(p, i, k) + MatrixChainOrderMemoization(p, k+1, j)
                        + p[i-1] * p[k] * p[j];
                if (cost < m[i][j]) {
                    m[i][j] = cost;
                }
            }
        }

        return m[i][j];
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4, 3};
        int n = arr.length;
        System.out.println("Minimum number of multiplications is "+
                MatrixChainOrderMemoization(arr, 1, 4));

    }
}