package bmstu.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class MapAirports extends Mapper<LongWritable, Text, AirportIndicator, Text> {

    private static final int AIRPORT_INDICATOR = 0;

    private static final int COLUMN_AIRPORT_CODE = 0;
    private static final int COLUMN_AIRPORT_DESCRIPTION = 1;


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        ReaderCSV table = new ReaderCSV(value);

        for (int i = 0; i < table.getSize(); i++) {
            AirportIndicator airportKeyIndicator = new AirportIndicator(
                    Integer.parseInt(table.getTableValueRowColumn(i, COLUMN_AIRPORT_CODE)),
                    AIRPORT_INDICATOR
            );
            Text airportName = new Text(table.getTableValueRowColumn(i, COLUMN_AIRPORT_DESCRIPTION));

            context.write(airportKeyIndicator, airportName);
        }

    }
}