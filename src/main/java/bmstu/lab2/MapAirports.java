package bmstu.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class MapAirports extends Mapper<LongWritable, Text, AirportIndicator, Text> {

    private static final int AIRPORT_INDICATOR = 0;

    private static final int COLUMN_AIRPORT_CODE = 0;
    private static final int COLUMN_AIRPORT_DESCRIPTION = 1;

    private static final String TITLE = "Code,Description";

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        ParserLineCSV table = new ParserLineCSV();
        table.lineBreak(value);

        if (!value.toString().equals(TITLE)) {
            AirportIndicator airportKeyIndicator = new AirportIndicator(
                    Integer.parseInt(table.getTableValue(COLUMN_AIRPORT_CODE)),
                    AIRPORT_INDICATOR
            );
            Text airportName = new Text(table.getTableValue(COLUMN_AIRPORT_DESCRIPTION));

            context.write(airportKeyIndicator, airportName);
        }




    }
}