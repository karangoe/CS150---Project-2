

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class TestLouncher.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestLouncher
{
    /**
     * Default constructor for test class TestLouncher
     */
    public TestLouncher()
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
    public void testConstruction(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:55 AM");
        arr.add("07:02:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        boolean theAns = false;
        if(l.getCustomers().get(0).getArrival() == 21600 &&
           l.getCustomers().get(1).getArrival() == 21655 &&
           l.getCustomers().get(2).getArrival() == 25320)theAns = true;
        boolean trueAns = true;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testPreliminaries(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:55 AM");
        arr.add("07:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        Event e1 = new Event("arrival",0,21600);
        Event e2 = new Event("arrival",1,21655);
        Event e3 = new Event("arrival",2,25200);
        boolean theAns=false;
        if(l.getCsh().poll().toString().equals(e1.toString()) && 
           l.getCsh().poll().toString().equals(e2.toString()) && 
           l.getCsh().poll().toString().equals(e3.toString())) theAns =true;
        boolean trueAns = true;
        assertEquals(theAns, trueAns);
    }
    
    
    @Test
    public void testSimulationNoOverflow(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:55 AM");
        arr.add("07:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float theAns = l.simulation();
        float trueAns = (float)6.00;
        assertEquals(theAns, trueAns, 0);
    }
    
    @Test
    public void testSimulationOverflow(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float theAns = l.simulation();
        float trueAns = (float)36.00;
        assertEquals(theAns, trueAns, 0);
    }
    
    @Test
    public void testOverflowNoOverflow(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:55 AM");
        arr.add("07:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float theAns = l.simulation();
        theAns = l.overflow();
        float trueAns = (float)0.00;
        assertEquals(theAns, trueAns, 0);
    }
    
    @Test
    public void testOverflowWithOverflow(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float theAns = l.simulation();
        theAns = l.overflow();
        float trueAns = (float)10.00;
        assertEquals(theAns, trueAns, 0);
    }
    
    @Test
    public void testMaxtWaitTimeNoWaitTime(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:55 AM");
        arr.add("07:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float temp = l.simulation();
        int theAns = l.maxWaitTime();
        int trueAns = 0;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testMaxWaitTimeWithWaitTime(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float temp = l.simulation();
        int theAns = l.maxWaitTime();
        int trueAns = 960;
        assertEquals(theAns, trueAns, 0);
    }
    
    @Test
    public void testAverageWaitTimeNoWaitTime(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:55 AM");
        arr.add("07:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float theAns = l.simulation();
        theAns = l.averageWaitTime();
        float trueAns = (float)0.00;
        assertEquals(theAns, trueAns, 0);
    }
    
    
    @Test
    public void testAverageWaitTimeWithWaitTime(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        arr.add("06:00:00 AM");
        Louncher l = new Louncher((float)2.00, (float)300.00, 120, 2, arr);
        l.preliminaries();
        float theAns = l.simulation();
        theAns = l.averageWaitTime();
        float trueAns = (float)480.00;
        assertEquals(theAns, trueAns, 0);
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
