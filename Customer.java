
/**
 * Customer class, with needed information about customer,
 * that is customer arrival time and time they got served.
 * Calculates waiting time, which is time from arriving to
 * getting served
 *
 * @author Elene Karangozishvili
 * @version 10.7.2018
 */

import java.util.*;

public class Customer
{
    private int arrivalTime;    //arrival time of the customer
    private int gettingServed;  //time at which customer gets to the cashier

    /**
     * Constructor for objects of class Customer
     * sets arrivalTime as the paramenter sent to it
     * and sets departureTime as arrivalTime-1, because
     * in case gettingServed is never set, we know the
     * customer was never served so the waiting time is
     * not applicable and the waiting time will be -1
     * 
     * @param _arrival arrival time of the customer
     */
    public Customer(int _arrival)
    {
        arrivalTime = _arrival;
        gettingServed = arrivalTime - 1;
    }
    
    /**
     * Sets departureTime as the parameter
     * sent to it
     * 
     * @param _departure time of the departure of the customer
     */
    public void setGettingServedTime(int _served)
    {
        gettingServed = _served;
    }
    
    /**
     * returns waiting time, that is time from arrival
     * to time they get served. If the customer was never served
     * returns -1.
     * 
     * @return the time between arriving and time of serving
     */
    public int waitingTime(){
        return gettingServed - arrivalTime;
    }
    
    public int getArrival(){
        return this.arrivalTime;
    }
}
