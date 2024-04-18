import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This program finds the max run and Strung blow up of the input to and from a file.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-04-14
 */
@SuppressWarnings("HideUtilityClassConstructor")
public class StringStuff {

  /**
   * Reads from a file, calls the necessary functions, then writes to another file.
   *
   * @param args The command line arguments (not used in this program).
   * @throws FileNotFoundException If the input file is not found.
   */
  public static void main(String[] args) throws FileNotFoundException {
    try {
      // File paths
      String in = "Assign/Assign-02/Assign-02-Java-StringStuff/input.txt";
      String out = "Assign/Assign-02/Assign-02-Java-StringStuff/output.txt";
      File input = new File(in);
      File output = new File(out);

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

        // calling max run function + read line
        fileLine = scanner.nextLine();
        maxRun = maxRun(fileLine.toCharArray());

        // writing output to output file
        writer.write("The string blow up is " + stringBlowUp + "\n");
        writer.write("The max run is " + maxRun + "\n");
      }

      // output was successful message
      System.out.println("The process was successful.");

      // close writer and scanner
      scanner.close();
      writer.close();

      // file could not be found
    } catch (IOException e) {
      System.out.println("File could not be found. Please fix the file path.");

      // missing
    } catch (NoSuchElementException e) {
      System.out.println(
          "There is a missing line in the file. Please make sure your input file is in order.");
    }
  }

  /**
   * Calculates the maximum consecutive run of identical characters in the given character array.
   *
   * @param input The input character array.
   * @return The maximum consecutive run of identical characters.
   */
  public static int maxRun(final char[] input) {
    // variables
    int currentRun = 0;
    int highestRun = 0;

    // loops through input to find the max run
    for (int index = 0; index < input.length; index++) {
      // if last character
      if (index == input.length - 1) {
        return highestRun;
      }
      // if the current character is the same as the next
      else if (input[index] == input[index + 1]) {
        currentRun++;

        // if the current run is higher than the highest run
        if (currentRun > highestRun) {
          highestRun = currentRun;
        }
      }
      // if the current character is not the same as the next
      else {
        currentRun = 0;
      }
    }
    // if this is returned there is something wrong with my program
    return -1;
  }

  /**
   * Performs string blow up operation on the given character array.
   *
   * @param input The input character array.
   * @return The processed string after applying the string blow up operation.
   */
  public static String stringBlowUp(final char[] input) {
    // variables
    String output = "";

    // loop through array
    for (int index = 0; index < input.length; index++) {
      // character is a digit
      if (Character.isDigit(input[index])) {
        // digit is the last character
        if (index + 1 == input.length) {
          return output;
        }
        // digit is not the last character
        else {
          // adds next character to output relative to the digit's value times
          int times = Character.getNumericValue(input[index]);
          output += String.valueOf(input[index + 1]).repeat(Math.max(0, times));
        }
      }
      // character is not a digit
      else {
        output += input[index];
      }
    }
    // return the output
    return output.toString();
  }
}
