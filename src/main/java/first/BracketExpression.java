package first;

public class BracketExpression {

    public static void main(String[] args) {
        System.out.println(getCountCorrectVariant(5));
    }

    /**
     *
     *Let C[n] - Regular Bracket sequence containing the N opening and closing braces N.
     *C[0] = 1 and C[n] = C[k]*C[n-1-k], for n>=1
     *
     * @param n must be >=1
     * @return C[n]
     */
    public static int getCountCorrectVariant(int n) {

        int[] countCorrectVariant = new int[n + 1];

        countCorrectVariant[0] = 1;
        //  To find C[n], you must first find the C[n-1]
        for (int m = 1; m <= n; m++) {
            for (int k = 0; k <= m - 1; k++) {
                countCorrectVariant[m] += countCorrectVariant[k] * countCorrectVariant[m - 1 - k];
            }
        }

        return countCorrectVariant[n];

    }

}
