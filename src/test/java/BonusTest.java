import bonus.Bonus;
import junit.framework.TestCase;
import org.junit.Test;

public class BonusTest extends TestCase{


    @Test
    public void testSwap1(){
        Bonus.Task1.x1 = 5;
        Bonus.Task1.x2 = 10;
        Bonus.Task1.swap1();
        assertEquals(Bonus.Task1.x1,10);
        assertEquals(Bonus.Task1.x2,5);
    }

    @Test
    public void testSwap2(){
        Bonus.Task1.x1 = 5;
        Bonus.Task1.x2 = 10;
        Bonus.Task1.swap2();
        assertEquals(Bonus.Task1.x1,10);
        assertEquals(Bonus.Task1.x2,5);
    }

    @Test
    public void testFib(){
        assertEquals(Bonus.Task4.fib(5),5);
        assertEquals(Bonus.Task4.fib(9),34);
    }

    @Test
    public void testSearch(){

        Bonus.Task2.search(9, 4, 42);
        assertEquals(Bonus.Task2.numberAccess,2);
        assertEquals(Bonus.Task2.numberFloor,2);

        Bonus.Task2.search(9, 4, 100);
        assertEquals(Bonus.Task2.numberAccess,3);
        assertEquals(Bonus.Task2.numberFloor,7);

    }

    @Test
    public void testNOD(){
        assertEquals(Bonus.Task3.nod4(10,15,20,25),5);
        assertEquals(Bonus.Task3.nod4(12, 36, 16, 24), 4);
    }

}
