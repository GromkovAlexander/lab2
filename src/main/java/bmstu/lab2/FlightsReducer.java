package bmstu.lab2;


import org.apache.hadoop.io.Text;

public class Reducer extends Reducer<AirportIndicator, Text, Text, Text> {
    @Override
    protected void reduce(AirportIndicator key, Iterable<Text> values, Context context) throws
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