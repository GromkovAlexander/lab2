package bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class AirportIndicator implements WritableComparable {
//    // Some data
//    private int counter;
//    private long timestamp;
//    private int value;

    private int key;
    private int indicator;

    public AirportIndicator() {
        this.key = 0;
        this.indicator = 0;
    }

    public AirportIndicator(int key, int indicator) {
        this.key = key;
        this.indicator = indicator;
    }

    @Override
    public void write(DataOutput out) throws IOException {
//        out.writeInt(counter);
//        out.writeLong(timestamp);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
//        counter = in.readInt();
//        timestamp = in.readLong();
    }

    @Override
    public int compareTo(AirportIndicator o) {
//        int thisValue = this.value;
//        int thatValue = o.value;
//        return (thisValue < thatValue ? -1 : (thisValue==thatValue ? 0 : 1));
    }

    @Override
    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + counter;
//        result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
//        return result;
    }
}