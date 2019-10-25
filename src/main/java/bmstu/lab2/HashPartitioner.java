package bmstu.lab2;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class HashPartitioner extends Partitioner<AirportIndicator, Text> {
    public int getPartition(AirportIndicator key, Text value, int numReduceTasks) {
        return Integer.hashCode(key.getKey()) % numReduceTasks;
    }
}