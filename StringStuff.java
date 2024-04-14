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
      int maxRun;

      // getting input from input file
      while (scanner.hasNextLine()) {
        // calling string blow up function + read line
        fileLine = scanner.nextLine();
        stringBlowUp = stringBlowUp(fileLine.toCharArray());

        // calling max tun function + read line
        fileLine = scanner.nextLine();
        maxRun = maxRun(fileLine.toCharArray());

        // writing output to output file
        writer.write("The string blow up is " + stringBlowUp + "\n");
        writer.write("The max run is " + Integer.toString(maxRun) + "\n");
      }

      // close writer and scanner
      scanner.close();
      writer.close();

    } catch (IOException e) {
      System.out.println("File could not be found. Please fix the file path.");
    }
  }

  public static int maxRun(char[] input) {
    // variables
    int currentRun = 0;
    int highestRun = 0;

    // loops through input to find the max run
    for (int index = 0; index < input.length; index++) {
      // if last character
      if (index == input.length - 1) {
        return highestRun;
        // if the current character is the same as the next
      } else if (input[index] == input[index + 1]) {
        currentRun++;

        // if the current run is higher than the highest run
        if (currentRun > highestRun) {
          highestRun = currentRun;
        }

        // if the current character is not the same as the next
      } else {
        currentRun = 0;
      }
    }
    // if this is returned there is something wrong with my program
    return -1;
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