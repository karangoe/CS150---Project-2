
/**
 * Event class, whith needed information about the event,
 * that is type of the event, time at which the event is taking
 * place and the identifying number of the customer that this
 * event is happening to
 *
 * @author Elene Karangozishvili
 * @version 10.7.2018
 */

public class Event implements Comparable <Event>
{
    private int customerNum;    //identifying number of customer
    private int time;           //time at which the event is taking place
    private String type;        //type of the event: "arrival" or "departure"

    /**
     * Constructor for objects of class Event
     * Sets customerNum, time and type according to
     * the parameters sent to it.
     * 
     * @param _type type of the event, departure of arrival
     * @param _customerNum the number that identifies the customer
     * @param _time time at which this event takes place
     */
    public Event(String _type, int _customerNum, int _time)
    {
        customerNum = _customerNum;
        time = _time;
        type = _type;
    }
    
    /**
     * defines compareTo method for the class to be 
     * Comparable. It compares only in terms of tume.
     * 
     * @return -1 if it's less, 0 if it's equal and 1 if it's more
     */
    public int compareTo(Event event){
        if(time < event.getTime()) return -1;
        if(time == event.getTime()) return 0;
        if(time > event.getTime()) return 1;
        return 0;
    }
    
    /**
     * @return time at which this event is taking place
     */
    public int getTime(){
        return time;
    }
    
    /**
     * @return the identifying number of the customer
     */
    public int getCustomerNum(){
        return customerNum;
    }
    
    /**
     * @return the type of this event
     */
    public String getType(){
        return type;
    }
    
    public String toString(){
        return this.type + " " + this.customerNum + " " +this.time;
    }

}
