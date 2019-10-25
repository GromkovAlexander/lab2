package bmstu.lab2;


import org.apache.hadoop.io.Text;

public class Partitioner<K, V> extends Partitioner<AirportIndicator, Text> {
    public int getPartition(K key, V value, int numReduceTasks) {
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}