import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program does some fun stuff with strings.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-04-14
 */

public class StringStuff {
  public static void main(String[] args) throws FileNotFoundException {
    try {
      // File paths
      File input = new File("Assign/Assign-02/Assign-02-Java-StringStuff/input.txt");
      File output = new File("Assign/Assign-02/Assign-02-Java-StringStuff/output.txt");

      // scanner and writer
      Scanner scanner = new Scanner(input);
      FileWriter writer = new FileWriter(output);

      // variable declaration
      String fileLine;
      String stringBlowUp;

      // getting input from input file
      while (scanner.hasNextLine()) {
        // calling string blow up function + read line
        fileLine = scanner.nextLine();
        stringBlowUp = stringBlowUp(fileLine.toCharArray());

        // calling max tun function + read line
        // fileLine = scanner.nextLine();
        // writing output to output file
        writer.write(stringBlowUp);
      }

      // close writer and scanner
      scanner.close();
      writer.close();

    } catch (IOException e) {
      System.out.println("File could not be found. Please fix the file path.");
    }
  }
  
  public static String stringBlowUp(char[] input) {
    // variables
    String output = "";

    // loop though array
    for (int index = 0; index < input.length; index++) {
      // character is a digit
      if ((input[index] >= '0' && input[index] <= '9')) {
        // digit is the last character
        if (index + 1 == input.length) {
          return output;

          // digit is not the last character
        } else {
          // adds next character to output relative to the digit's value times
          for (int counter = 0; counter < input[index] - '0'; counter++) {
            output += input[index + 1];
          }
        }
        // character is not a digit
      } else {
        output += input[index];
      }
    }

    // return the output
    return output;
  }
}