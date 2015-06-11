import junit.framework.TestCase;
import org.junit.Test;
import third.FactorialUtil;

public class FactorialUtilTest extends TestCase {

    @Test
    public void testSumDigitsFactorial() {

        assertEquals(FactorialUtil.sumDigitsFactorial(1), 1);
        assertEquals(FactorialUtil.sumDigitsFactorial(2), 2);
        assertEquals(FactorialUtil.sumDigitsFactorial(3), 6);
        assertEquals(FactorialUtil.sumDigitsFactorial(4), 6);
        assertEquals(FactorialUtil.sumDigitsFactorial(5), 3);
        assertEquals(FactorialUtil.sumDigitsFactorial(100), 648);

    }

}
