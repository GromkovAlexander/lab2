package bmstu.lab2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AirportJoinApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: AirportJoinApp <flights file path> <airports file path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(AirportJoinApp.class);
        job.setJobName("AirportJoinApp count");


        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, MapAirports.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, MapFlights.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setPartitionerClass(HashPartitioner.class);
        job.setGroupingComparatorClass(KeysComparator.class);
        job.setReducerClass(FlightsReducer.class);
        job.setMapOutputKeyClass(AirportIndicator.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

