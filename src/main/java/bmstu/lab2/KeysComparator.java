package bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class KeysComparator extends WritableComparator {

    public KeysComparator() {
        super(AirportIndicator.class, true);
    }

    public int compare(WritableComparable a, WritableComparable b) {
        AirportIndicator one = (AirportIndicator) a;
        AirportIndicator two = (AirportIndicator) b;
        return one.compareKeys(two);
    }
}