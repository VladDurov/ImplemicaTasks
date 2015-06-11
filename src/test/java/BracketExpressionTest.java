import junit.framework.TestCase;
import org.junit.Test;
import first.BracketExpression;

public class BracketExpressionTest extends TestCase {

    @Test
    public void testGetCountCorrectVariant() {

        assertEquals(BracketExpression.getCountCorrectVariant(0), 1);
        assertEquals(BracketExpression.getCountCorrectVariant(1), 1);
        assertEquals(BracketExpression.getCountCorrectVariant(2), 2);
        assertEquals(BracketExpression.getCountCorrectVariant(3), 5);
        assertEquals(BracketExpression.getCountCorrectVariant(4), 14);
        assertEquals(BracketExpression.getCountCorrectVariant(10), 16796);
        assertEquals(BracketExpression.getCountCorrectVariant(16), 35357670);

    }

}
