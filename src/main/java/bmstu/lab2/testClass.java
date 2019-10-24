package bmstu.lab2;

import java.io.FileReader;
import java.util.Arrays;
import au.com.bytecode.opencsv.CSVReader;

public class testClass {
    public static void main(String[] args) throws Exception {
        //Build reader instance
        //Read data.csv
        //Default seperator is comma
        //Default quote character is double quote
        //Start reading from line number 2 (line numbers start from zero)
        CSVReader reader = new CSVReader(new FileReader("664600583_T_ONTIME_sample.csv"), ',' , '"' , 1);
        //Read CSV line by line and use the string array as you want
        String[] nextLine;
        int count = 0;
        while ((nextLine = reader.readNext()) != null && count <= 10) {
            if (nextLine != null) {
                //Verifying the read data here
                System.out.println(Arrays.toString(nextLine));
            }
            count++;
        }
    }
}
