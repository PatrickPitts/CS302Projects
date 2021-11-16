package org.nerdcore.project4.package4;
import java.util.concurrent.ThreadLocalRandom;
public class Event {
    //1 = Arrival, 0 = Departure
    private final int EVENT_TYPE;

    public Event(int event_type) {
        EVENT_TYPE = event_type;
    }

    public Event(){
        EVENT_TYPE = ThreadLocalRandom.current().nextInt(0,2);
    }

    public int get_event(){
        return EVENT_TYPE;
    }
}
