import java.util.Scanner;
import java.util.Random;

public class ArrayStuff {

    public static void main(String[] args) {

        Random rand = new Random(); // initialize randomizer
        Scanner in =  new Scanner(System.in); // initialize scanner
        int[] dataPoints = new int[100]; // declare int array of size 100
        int total = 0; // sum of all elements in the array
        int average = 0; // average of all elements in the array
        int inputFound = 0; // counter for how many times the user input is found within the array

        // for each iteration, set the current element of dataPoints to a random number 1-100
        for (int i = 0; i < 100; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        System.out.println("Random array dataPoints:"); // explain what it's about to print

        // print entire array
        for (int i = 0; i < 100; i++) {

            // for every number except for the last one, print the element and the separator
            if (i != 99) {
                System.out.print(dataPoints[i] + " | ");

            } else { // if it's the last one (index is 99) just print the element at index i
                System.out.print(dataPoints[i]);
            }
        }

        // calculate total and average
        for (int i = 0; i < 100; i++) {
            total += dataPoints[i];
            average = total / 100;
        }

        // print total and average
        System.out.println("\nThe total of all elements in dataPoints is: " + total + "\nThe average is: " + average);


        // get an int 1-100 from the user
        int input = SafeInput.getRangedInt(in, "Pick a number", 1, 100);

        // for each element, check if it matches the input we just got
        for (int i = 0; i < 100; i++) {
            if (dataPoints[i] == input) {
                inputFound++;
            }
        }

        // print out the number of times the input was found in the array, modifying the statement if it's 0 or 1
        if (inputFound == 0) {
            System.out.println("The number " + input + " does not occur anywhere within the array.");

        } else if (inputFound == 1) {
            System.out.println("The number " + input + " occurs " + inputFound + " time within the array.");

        } else {
            System.out.println("The number " + input + " occurs " + inputFound + " times within the array.");
        }

    }
}
