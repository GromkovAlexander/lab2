package bmstu.lab2;

import java.io.FileReader;
import java.util.Arrays;
import au.com.bytecode.opencsv.CSVReader;

public class testClass {
    public static void main(String[] args) throws Exception {

        //664600583_T_ONTIME_sample.csv
        //L_AIRPORT_ID.csv
        CSVReader reader = new CSVReader(new FileReader("664600583_T_ONTIME_sample.csv"), ',' , '"' , 1);

        String[] nextLine;
        int count = 0;
        while ((nextLine = reader.readNext()) != null && count <= 10) {
            if (nextLine != null) {
                //Verifying the read data here
                System.out.println(Arrays.toString(nextLine));
            }
            count++;
        }
        //test auto-commit
    }
}
