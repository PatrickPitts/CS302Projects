package org.nerdcore.project4.package4;

public class Customer {
    private int arrival_time;
    private int priority;

    public Customer(int priority, int arrival_time) {
        this.priority = priority;
        this.arrival_time = arrival_time;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "arrival_time=" + arrival_time +
                ", priority=" + priority +
                '}';
    }
}
