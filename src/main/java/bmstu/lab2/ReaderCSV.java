package bmstu.lab2;

import org.apache.hadoop.io.Text;

import java.util.ArrayList;


public class ReaderCSV {
    private ArrayList<ArrayList<String>> table;

    private static final char QUOTES = '"';
    private static final char COMMA = ',';
    private static final char SPACE = ' ';


    public ReaderCSV(Text input)  {
        String text = input.toString();
        String[] lines = text.split("\n");
        table = new ArrayList<>(lines.length);

        for (String line : lines) {
            ArrayList<String> column = new ArrayList<>();
            table.add(column);
            for (int i = 0; i < line.length(); i++) {

                if (line.charAt(i) == QUOTES) {
                    int j = i + 1;
                    while (j < line.length() && line.charAt(j) != QUOTES) {
                        j++;
                    }
                    column.add(line.substring(i + 1, j));
                    i = j;
                    continue;
                }

                if (line.charAt(i) == COMMA) {
                    if (i + 1 < line.length() && line.charAt(i + 1) == QUOTES) {
                        continue;
                    }
                    int j = i + 1;
                    while (j < line.length() && line.charAt(j) != COMMA) {
                        j++;
                    }
                    column.add(line.substring(i + 1, j));
                    i = j - 1;
                    continue;
                }

                if (line.charAt(i) != SPACE) {
                    int j = i;
                    while (line.charAt(j) != QUOTES && line.charAt(j) != COMMA) {
                        j++;
                    }
                    column.add(line.substring(i, j));
                    i = j - 1;
                }
            }
        }
    }



}
