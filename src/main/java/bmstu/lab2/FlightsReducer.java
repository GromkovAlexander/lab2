package bmstu.lab2;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
import java.util.Iterator;

public class FlightsReducer extends Reducer<AirportIndicator, Text, IntWritable, Text> {

    @Override
    protected void reduce(AirportIndicator key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        
        float min = Float.MAX_VALUE;
        float max = Float.MIN_VALUE;
        float sum = 0;
        float count = 0;

        Iterator<Text> iter = values.iterator();
        String firstOutPart = iter.next().toString();

        while (iter.hasNext()) {
            float delay = Float.parseFloat(iter.next().toString());

            if (delay < min) {
                min = delay;
            }

            if (delay > max) {
                max = delay;
            }

            sum += delay;
            count++;
        }

        if (count > 0) {
            float averageDelay = sum / count;
            Text out = new Text(firstOutPart + " Minimum delay: " + min + " Maximum delay: " + max + " Average delay: " + averageDelay )
            context.write(new IntWritable(key.getKey()), out);
        }


    }
}