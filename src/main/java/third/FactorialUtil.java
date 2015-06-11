package third;

import java.math.BigInteger;

public class FactorialUtil {

    public static void main(String[] args) {
        sumDigitsFactorial(100);
    }

    /**
     *  Return the sum of digits of the factorial
     *  For example: 5! = 3, 100! = 648.
     * @param n
     * @return sum digits n!
     */
    public static int sumDigitsFactorial(int n) {

        String s = "" + getFactorial(n);

        int sum = 0;

        for (char ch : s.toCharArray()) {
            sum += ch - '0'; //ch - '0' convert char to int
        }

        System.out.println(n + "! => [" + s + "]" + " => " + sum);

        return sum;
    }

    /**
     *  Return product of all positive integers less than or equal to n. Under the arrangement: 0! = 1
     *  For example: 5! = 1*2*3*4*5 = 120.
     * @param n
     * @return n!
     */
    public static BigInteger getFactorial(int n) {

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;

    }

}
