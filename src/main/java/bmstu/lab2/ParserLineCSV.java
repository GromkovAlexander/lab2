package bmstu.lab2;

import org.apache.hadoop.io.Text;

import java.util.ArrayList;


public class ParserLineCSV {
    private ArrayList<String> table;

    private static final char QUOTES = '"';
    private static final char COMMA = ',';
    private static final char SPACE = ' ';

    public ParserLineCSV() {
        table = new ArrayList<>();
    }


    public void lineBreak(Text input) {
        String line = input.toString();

        for (int i = 0; i < line.length(); i++) {

            if (line.charAt(i) == QUOTES) {
                int j = i + 1;
                while (j < line.length() && line.charAt(j) != QUOTES) {
                    j++;
                }
                table.add(line.substring(i + 1, j));
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
                table.add(line.substring(i + 1, j));
                i = j - 1;
                continue;
            }

            if (line.charAt(i) != SPACE) {
                int j = i;
                while (line.charAt(j) != QUOTES && line.charAt(j) != COMMA) {
                    j++;
                }
                table.add(line.substring(i, j));
                i = j - 1;
            }
        }

    }

    public String getTableValue(int column) {

        return table.get(column);
    }


}
