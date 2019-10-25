package bmstu.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapFlights extends Mapper<LongWritable, Text, AirportIndicator, Text> {

    private static final int FLIGHTS_INDICATOR = 1;

    private static final int COLUMN_AIRPORT_CODE = 14;
    private static final int COLUMN_AIRPORT_DELAY = 17;


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        ReaderCSV table = new ReaderCSV(value);

        for (int i = 0; i < table.getSize(); i++) {
            try {
                AirportIndicator airportKeyIndicator = new AirportIndicator(
                        Integer.parseInt(table.getTableValueRowColumn(i, COLUMN_AIRPORT_CODE)),
                        FLIGHTS_INDICATOR
                );

                String delayString = table.getTableValueRowColumn(i, COLUMN_AIRPORT_DELAY);

                if (delayString.length() > 0) {
                    Text delayText = new Text(delayString);
                    context.write(airportKeyIndicator, delayText);
                }
            } catch (NumberFormatException ex) {
                //Строка с заголовками
            }


        }

    }
}