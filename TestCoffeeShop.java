

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestCoffeeShop.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestCoffeeShop
{
    /**
     * Default constructor for test class TestCoffeeShop
     */
    public TestCoffeeShop()
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
    public void testPoll(){
        CoffeeShop csh = new CoffeeShop();
        Event e1 = new Event("arrival",7,256);
        Event e2 = new Event("departure", 3, 283);
        csh.add(e1);
        csh.add(e2);
        Event theAns = csh.poll();
        Event trueAns = e1;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testIsEmptyNotEmpty(){
        CoffeeShop csh = new CoffeeShop();
        Event e1 = new Event("arrival",7,256);
        Event e2 = new Event("departure", 3, 283);
        csh.add(e1);
        csh.add(e2);
        boolean theAns = csh.isEmpty();
        boolean trueAns = false;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testIsEmptyEmpty(){
        CoffeeShop csh = new CoffeeShop();
        Event e1 = new Event("arrival",7,256);
        Event e2 = new Event("departure", 3, 283);
        csh.add(e1);
        csh.add(e2);
        csh.poll();
        csh.poll();
        boolean theAns = csh.isEmpty();
        boolean trueAns = true;
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
