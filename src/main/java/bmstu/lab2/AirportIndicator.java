package bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;


public class AirportIndicator implements WritableComparable<AirportIndicator> {

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
        out.writeInt(this.key);
        out.writeInt(this.indicator);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.key = in.readInt();
        this.indicator = in.readInt();
    }

    @Override
    public int compareTo(AirportIndicator o) {
        if (Integer.compare(this.key, o.key) != 0) {
            return Integer.compare(this.key, o.key);
        } else {
            return Integer.compare(this.indicator, o.indicator);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.indicator);
    }

    public int compareKeys(AirportIndicator o) {
        return Integer.compare(this.key, o.key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }
}