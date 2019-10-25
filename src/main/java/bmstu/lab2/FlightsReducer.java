package bmstu.lab2;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapOutputCollector;

import java.io.IOException;
import java.util.Iterator;

public class FlightsReducer extends FlightsReducer<AirportIndicator, Text, Text, Text> {
    @Override
    protected void reduce(AirportIndicator key, Iterable<Text> values, MapOutputCollector.Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text systemInfo = new Text(iter.next());
        while (iter.hasNext()) {
            Text call = iter.next();
            Text outValue = new Text(call.toString() + "\t" + systemInfo.toString());
            context.write(key.getFirst(), outValue);
        }
    }
}