
/**
 * Reads input, runs the sumulation of the coffee shop,
 * writes the results
 *
 * @author Elene Karangozishvili
 * @version 10.7.2018
 */

import java.util.*;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;

public class Louncher
{
    private float p;                                                    //estimated profit per customer
    private float c;                                                    //estimated cost of hiring one cashier
    private int t;                                                      //estimated time of serving one customer
    private int cashNum;                                                //number of cashiers
    private CoffeeShop csh = new CoffeeShop();                          //instance of CoffeeShop, which has an access to priority queue
    private ArrayList<Customer> customers = new ArrayList<Customer>();  //ArrayList of customers
    
    /**
     * Constructor for objects of class Louncher
     * Sets p, c, t, arr from the paramenters sent to it,
     * sorts arr and initialized elements is the ArrayList
     * costumers using arr.
     * 
     * @param _p profit of serving each costumer
     * @param _c cost of each cashier per day
     * @param _t time cashier takes to serve each customer
     * @param _arr ArrayList of arrival times of the costomers
     */
    public Louncher(float _p, float _c, int _t, int _cashNum, ArrayList<String> arrString)
    {
        p = _p;
        c = _c;
        t = _t;
        cashNum = _cashNum;
        for(int i=0;i<arrString.size();i++){
            int time = 0;
            int hour = (Integer.parseInt(arrString.get(i).substring(0,2)));
            int minute = (Integer.parseInt(arrString.get(i).substring(3,5)));
            int second = (Integer.parseInt(arrString.get(i).substring(6,8)));
            time = hour*60*60 + minute*60 + second;
            if(time<=22*60*60){
                Customer cus = new Customer(time);
                customers.add(cus); 
            }
        }
    }

    /**
     * reads from the input file and output the answers
     */
    public static void main(String[] args){
        int cashNum = Integer.parseInt(args[0]);
        float p = 0;
        float c = 0;
        int t = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<String> arrString = new ArrayList<String>();
        try{
            Scanner sc = null;
            sc = new Scanner(new File("input.txt"));
            String s = null;
            if (sc.hasNextLine()) s = sc.nextLine();
            p = Float.parseFloat(s);
            if (sc.hasNextLine()) s = sc.nextLine();
            c = Float.parseFloat(s);
            if (sc.hasNextLine()) s = sc.nextLine();
            t = Integer.parseInt(s);
            while(sc.hasNextLine()){
                s = sc.nextLine();
                arrString.add(s);
            }
        }
        catch(Exception e){
        }
        
        Louncher lnc = new Louncher(p, c, t, cashNum, arrString);
        lnc.preliminaries();
        float tProfit = lnc.simulation();
        System.out.println("Total Profit: " + tProfit);
        System.out.println("Total Cost: " + (cashNum*c));
        System.out.println("Net Profit: " + (tProfit - cashNum*c));
        System.out.println("Avarage Wait time: " + lnc.averageWaitTime());
        System.out.println("Max Wait Time: "+ lnc.maxWaitTime());
        System.out.println("Overflow Rate: "+ lnc.overflow()+"%");
    }
    
    /**
     * Based on arrival times, creates events and adds them
     * to csh 
     */
    public void preliminaries(){
        for(int i = 0; i<this.customers.size(); i++){
            Event event = new Event("arrival", i, this.customers.get(i).getArrival());
            csh.add(event);
        }
    }
    
    /**
     * runs the simulation of the coffee shop
     * 
     * @return total profit
     */
    public float simulation(){
        float totalIncome = 0;
        int avalableCashiers = cashNum;
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int iWantToSeeThisCus = -1;
        while(!csh.isEmpty()){
            Event event = csh.poll();
            if(event.getType()=="arrival"){
                if(queue.size()<8*cashNum){
                    queue.add(event.getCustomerNum());
                    totalIncome+=p;
                }
            }
            
            if(event.getType() == "departure"){
                avalableCashiers++;
                customers.get(event.getCustomerNum()).setGettingServedTime(event.getTime()-this.t);
            }
            
            if(avalableCashiers>0 && queue.size()>0){
                avalableCashiers--;
                Event departure = new Event("departure", queue.poll(), event.getTime()+this.t);
                csh.add(departure);
            }
        }
        return totalIncome;
    }
    
    /**
     * Calculates the persantage of customers
     * who were turned away
     * 
     * @return persentage of turned away customers
     */
    public float overflow(){
        int turnedAway=0;
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).waitingTime()<0) turnedAway++;
        }
        return (float)turnedAway/customers.size()*100;
    }
    
    /**
     * Calculates the maximum time from arriving
     * to getting served
     * 
     * @return maximum time from arriving to getting served
     */
    public int maxWaitTime(){
        int MWT = 0;
        for(int i=0;i<customers.size();i++){
            if(MWT<customers.get(i).waitingTime()) MWT = customers.get(i).waitingTime();
        }
        return MWT;
    }
    
    /**
     * calculates avarage time from arriving to getting
     * served
     * 
     * @return avarage time from arriving to getting served
     */
    public float averageWaitTime(){
        float total = 0;
        int numberOfCustomersServed = 0;
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).waitingTime()>=0){
                total = total + customers.get(i).waitingTime();
                numberOfCustomersServed++;
            }
        }
        return total/numberOfCustomersServed;
    }
    
    public CoffeeShop getCsh(){
        return this.csh;
    }
    
    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }
}
