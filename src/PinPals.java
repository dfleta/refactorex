
import com.github.freva.asciitable.AsciiTable;

public class PinPals {
    public static void main( String[] args ) {

        System.out.println("\nSmokey, this is not Vietnam, this is bowling. There are rules. -The Dude\n");

        String[] headers = {"Frame 1", "Frame 2", "Frame 3", "Frame 4", "Frame 5", 
                            "Frame 6", "Frame 7", "Frame 8", "Frame 9", "Frame 10"};

        String[][] data = {
            {"9 | -", "9 | -", "9 | -", "9 | -", "9 | -", "9 | -", "9 | -", "9 | -", "9 | -", "9 | -"}
        };

        System.out.println(AsciiTable.getTable(headers, data));
    }
}
