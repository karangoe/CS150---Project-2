import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestCustomer.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestCustomer
{
    /**
     * Default constructor for test class TestCustomer
     */
    public TestCustomer()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void testGettingServed(){
        Customer c = new Customer (10);
        c.setGettingServedTime(310);
        int theAns = c.waitingTime();
        int trueAns = 300;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testGettingServedInstantly(){
        Customer c = new Customer (10);
        c.setGettingServedTime(10);
        int theAns = c.waitingTime();
        int trueAns = 0;
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
