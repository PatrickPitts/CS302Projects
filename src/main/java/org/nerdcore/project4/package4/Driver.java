package org.nerdcore.project4.package4;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
public class Driver {
    public static void main(String[] args) {
        PriorityQueue<Customer> Q = new PriorityQueue<>(new CustomerCompare());
        int tick = 0;
        int num_ticks = 100;
        Event E;
        int count = 0;
        double waits = 0.0;
        while(tick++ < num_ticks){
            E = new Event();
            //1 = Arrival, 0 = Departure(s)
            switch (E.get_event()){
                case 1:
                    Q.add(new Customer(ThreadLocalRandom.current().nextInt(1, 101), tick));
                    break;
                case 0:
                    if(Q.isEmpty()){
                        System.out.println("No Customers in PriorityQueue!");
                    } else {
                        int pr = Q.peek().getPriority();
                        while(!Q.isEmpty() && Q.peek().getPriority() == pr){
                            Customer c = Q.poll();
                            waits += (tick - c.getArrival_time());
                            count++;
                        }
                        System.out.printf("The average wait time for %s customers was %.3f ticks%n", count, waits/count);
                    }
                    break;
            }
        }
    }
}
