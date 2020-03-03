import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random; 
/**
* This program allows user to pick a min and max value for a random number.
*
* @author  Christina Ngwa
* @version 1.0
* @since   2020-02-29
*/

public class RandomNumber {
  /**
  * This method allows user to pick a min and max value for a random number.
  */
  public static void main(String[] args) throws IOException {
  
    // variables
    final int rand1;
    final int rand2;
    int minValue;
    int maxValue;
    
    // reads user input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("Welcome to the random number generator!\n");
    
    // input
    while (true) {
      System.out.print("Enter a maximum value: ");
      try {
        maxValue = Integer.parseInt(br.readLine());
        break;
      } catch (NumberFormatException nfe) {
        System.err.println("Invalid input. Please try again.");
      }
    }

    while (true) {
      System.out.print("Enter a minimum value: ");
      try {
        minValue = Integer.parseInt(br.readLine());
        if (minValue < maxValue) {
          break;
        } else {
          System.err.println("Enter a logical range.");
        }
      } catch (NumberFormatException nfe) {
        System.err.println("Invalid input. Please try again.");
      }
    }

    // call method
    rand1 = rollDie(maxValue);
    rand2 = rollDice(maxValue, minValue);

    // output
    System.err.println("\nYour random number is 1-" + maxValue + " is " 
                       + rand1 + ".");
    System.err.println("\nYour random number from " + minValue + "-" 
                       + maxValue + " is " + rand2 + ".");
  }

  /**
  * This method generates a random number from 1 to max value.
  */
  public static int rollDie(int maxValue) {

    // process
    Random rand = new Random(); 
    int randInt = rand.nextInt(maxValue) + 1;

    return randInt;
  }

  /**
  * This method generates a random number from min to max value.
  */
  public static int rollDice(int maxValue, int minValue) {

    // process
    Random rand = new Random(); 
    int randInt = rand.nextInt(maxValue - minValue + 1) + minValue;

    return randInt;
  }
}