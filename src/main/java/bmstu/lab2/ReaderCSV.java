package bmstu.lab2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import au.com.bytecode.opencsv.CSVReader;

import org.apache.hadoop.io.Text;

import java.util.ArrayList;


public class ReaderCSV {
    private ArrayList<ArrayList<String>> table;

    private static final char QUOTES = '"';
    private static final char COMMA = ',';


    public ReaderCSV(Text input)  {
        String help = input.toString();
        String[] lines = help.split("\n");
        table = new ArrayList<>(lines.length);

        for (String line : lines) {
            ArrayList<String> column = new ArrayList<>();
            table.add(column);
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == QUOTES) {
                    if (i + 1 < line.length()) {
                        continue;
                    }
                    int j = i + 1;
                    while (j < line.length() && line.charAt(j) != QUOTES) {
                        j++;
                    }
                    column.add(line.substring(i + 1, j));
                    i = j;
                    continue;
                }

                if (line.charAt(i) == COMMA) {
                    if (i + 1 < line.length()) {
                        continue;
                    }
                    int j = i + 1;
                    while (j < line.length() && line.charAt(j) != COMMA) {
                        j++;
                    }
                    column.add(line.substring(i + 1, j);
                }
            }
        }

    }



}
