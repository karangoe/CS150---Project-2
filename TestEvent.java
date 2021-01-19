

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestEvent.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestEvent
{
    /**
     * Default constructor for test class TestEvent
     */
    public TestEvent()
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
    public void testComapareToLess(){
        Event e1 = new Event("arrival",7,283);
        Event e2 = new Event("departure", 3, 234);
        int theAns = e2.compareTo(e1);
        int trueAns = -1;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testComapareToEqual(){
        Event e1 = new Event("arrival",7,283);
        Event e2 = new Event("departure", 3, 283);
        int theAns = e1.compareTo(e2);
        int trueAns = 0;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testGetType(){
        Event e1 = new Event("arrival",7,283);
        String theAns = e1.getType();
        String trueAns = "arrival";
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testGetCustomerNum(){
        Event e1 = new Event("arrival",7,283);
        int theAns = e1.getCustomerNum();
        int trueAns = 7;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testGetTime(){
        Event e1 = new Event("arrival",7,283);
        int theAns = e1.getTime();
        int trueAns = 283;
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
