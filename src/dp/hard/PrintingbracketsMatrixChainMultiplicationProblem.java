package dp.hard;

/**
 * https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/
 */
public class PrintingbracketsMatrixChainMultiplicationProblem {

    public static int MatrixChainOrderDynamic(int p[], int n) {
        /**
         * matrix[i][j] multiplications of A[i]...A[j]
         * 0th row and 0th column of m[][] are not used
         *
         */
        int[][] matrix = new int[n][n];
        int[][] split = new int[n][n];

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
                    if (q < matrix[i][j]) {
                        matrix[i][j] = q;
                        split[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Optimal Parenthesization is : ");
        printParenthesis(1, n-1, split, new char[]{'A'});
        return matrix[1][n-1];
    }

    public static void printParenthesis(int i, int j, int[][] bracket, char[] name) {
        if (i == j) {
            System.out.print(name[0]);
            name[0]++;
            return;
        }

        System.out.print('(');
        printParenthesis(i, bracket[i][j], bracket, name);

        printParenthesis(bracket[i][j]+1, j, bracket, name);
        System.out.print(')');
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(MatrixChainOrderDynamic(arr, 5));
    }

}
