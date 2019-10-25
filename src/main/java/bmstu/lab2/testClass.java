package bmstu.lab2;

import org.apache.hadoop.io.Text;

import java.util.ArrayList;

import java.io.FileReader;
import java.util.Arrays;
import au.com.bytecode.opencsv.CSVReader;

public class testClass {
    public static void main(String[] args) throws Exception {

//        //664600583_T_ONTIME_sample.csv
//        //L_AIRPORT_ID.csv
//        CSVReader reader = new CSVReader(new FileReader("664600583_T_ONTIME_sample.csv"), ',' , '"' , 1);
//
//        String[] nextLine;
//        int count = 0;
//        while ((nextLine = reader.readNext()) != null && count <= 10) {
//            if (nextLine != null) {
//                //Verifying the read data here
//                System.out.println(Arrays.toString(nextLine));
//            }
//            count++;
//        }
        String s1 = "\"10001\",Afognak Lake, AK: Afognak Lake Airport";
        String s2 = "\"10003\",\"Granite Mountain, AK: Bear Creek Mining Strip\"";
        "10004","Lik, AK: Lik Mining Camp"
        "10005","Little Squaw, AK: Little Squaw Airport"
        String s2 =  "10003" + "," + "Granite Mountain, AK: Bear Creek Mining Strip";
        String s3 =  "10004" + "," + "Lik, AK: Lik Mining Camp";
        String s4 =  "10005" + "," + "Little Squaw, AK: Little Squaw Airport";
        String itog = s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n";
        Text text = new Text(itog);

        ReaderCSV check = new ReaderCSV(text);


    }
}
