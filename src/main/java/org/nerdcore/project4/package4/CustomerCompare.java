package org.nerdcore.project4.package4;

import java.util.Comparator;

public class CustomerCompare implements Comparator<Customer> {
    @Override
    public int compare(Customer o, Customer t1) {
        return o.getPriority() - t1.getPriority();
    }
}
