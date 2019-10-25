package bmstu.lab2;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partitioner<AirportIndicator, Text> extends Partitioner<AirportIndicator, Text> {
    public int getPartition(AirportIndicator key, Text value, int numReduceTasks) {
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}