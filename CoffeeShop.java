
/**
 * CoffeeShop class controlls the priority queue
 * of the events
 *
 * @author Elene Karangozishvili
 * @version 10.7.2018
 */

import java.util.*;

public class CoffeeShop
{
    private  PriorityQueue<Event> pQueue;   //priority queue with events

    /**
     * Constructor for objects of class CoffeeShop
     * initializes the priority queue
     */
    public CoffeeShop()
    {
        pQueue = new PriorityQueue<Event>();
    }

    /**
     * Adds event to the priority queue
     */
    public void add(Event event)
    {
        pQueue.add(event);
    }
    
    /**
     * returns top event from the priority
     * queue and removes it.
     * 
     * @return top event in priority queue
     */
    public Event poll(){
        return pQueue.poll();
    }
    
    /**
     * Checks if the priority queue is empty
     * 
     * @return true if the priority queue is empty
     * and false if the priority queue is not empty
     */
    public boolean isEmpty(){
        return pQueue.isEmpty();
    }
}
