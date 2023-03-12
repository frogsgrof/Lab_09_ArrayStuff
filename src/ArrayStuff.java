import java.util.Scanner;
import java.util.Random;

public class ArrayStuff {

    public static void main(String[] args) {

        Random rand = new Random(); // initialize randomizer
        Scanner in =  new Scanner(System.in); // initialize scanner
        int[] dataPoints = new int[100]; // declare int array of size 100

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

        int total = 0; // sum of all elements in the array
        int average = 0; // average of all elements in the array

        // calculate total and average
        for (int i = 0; i < 100; i++) {
            total += dataPoints[i];
            average = total / 100;
        }

        // print non-method total and average
        System.out.println("\n\n   Total & Average\n◇◆◇◆◇◆◇◆◇◆◇◇◆◇◆◇◆◇◆◇◆◇\n" +
                "From non-method code:\n" +
                "The total of all elements in dataPoints is: " + total + "\n" +
                "The average is: " + average);

        // print same using total & average methods
        System.out.println("\nUsing methods:\n" +
                "The total of all elements in dataPoints is: " + sum(dataPoints) + "\n" +
                "The average is: " + getAverage(dataPoints));

        // get an int 1-100 from the user
        int input = SafeInput.getRangedInt(in, "Pick a number", 1, 100);
        int inputFound = 0; // counter for how many times the user input is found within the array

        // for each element, check if it matches the input we just got
        for (int i = 0; i < 100; i++) {
            if (dataPoints[i] == input) {
                inputFound++;
            }
        }

        // non-method print:
        System.out.print("\n    Scanning for the number " + input + "\n◇◆◇◆◇◆◇◆◇◆◇◇◆◇◆◇◆◇◆◇◆◇◇◆◇◆◇◆◇◆◇◆◇\n" +
                "From non-method code: ");

        // print out the number of times the input was found in the array, modifying the statement if it's 0 or 1
        if (inputFound == 0) {
            System.out.println("The number " + input + " does not occur anywhere within the array.");

        } else if (inputFound == 1) {
            System.out.println("The number " + input + " occurs once within the array.");

        } else {
            System.out.println("The number " + input + " occurs " + inputFound + " times within the array.");
        }

        // using method:
        System.out.print("Using method: ");

        // exact same conditional as with the non-method print
        if (occurrenceScan(dataPoints, input) == 0) {
            System.out.println("The number " + input + " does not occur anywhere within the array.");

        } else if (occurrenceScan(dataPoints, input) == 1) {
            System.out.println("The number " + input + " occurs once within the array.");

        } else {
            System.out.println("The number " + input + " occurs " + occurrenceScan(dataPoints, input) + " time within the array.");
        }

        // get another int 1-100 from the user
        input = SafeInput.getRangedInt(in, "Pick another number", 1, 100);
        int indexFound = -1; // stores the index at which the input was found in the array

        // check each value for matching the input except break after 1 match
        for (int i = 0; i < 100; i++) {
            if (dataPoints[i] == input) {
                indexFound = i; // set indexFound to the current index
                break;
            }
        }

        // non-method print:
        System.out.print("\n   First Occurrence\n◇◆◇◆◇◆◇◆◇◆◇◇◆◇◆◇◆◇◆◇◆◇\n" +
                "From non-method code: ");

        // if indexFound is still -1, that means the number was not found
        if (indexFound == -1) {
            System.out.println("The number " + input + " does not occur anywhere within the array.");

        } else { // all other cases just print where the number was found
            System.out.println("The first occurrence of the number " + input + " is at index " + indexFound + " within the array.");
        }

        // method print:
        System.out.print("Using method: ");

        if (contains(dataPoints, input)) {
            System.out.println("The number " + input + " can be found in the array dataPoints.");
        } else {
            System.out.println("The number " + input + " does not occur anywhere within the array.");
        }

        int min = 100; // stores min value in array
        int max = 0; // stores max value in array

        // for each number, check if it's less than the current minimum. if not, check if it's greater than the current max
        for (int i = 0; i < 100; i++) {

            // if it's less than the min, it becomes the new min
            if (dataPoints[i] <= min) {
                min = dataPoints[i];

            // if it's greater than the max, it becomes the new max
            } else if (dataPoints[i] >= max) {
                max = dataPoints[i];
            }
        } // keeps checking for all the elements in the array

        // non-method print
        System.out.println("\n Min & Max\n◇◆◇◆◇◆◇◆◇◆◇" +
                "\nFrom non-method code: ");
        System.out.println("The lowest number to be found in the array is: " + min);
        System.out.println("The highest number to be found in the array is: " + max);

        // method print
        System.out.println("\nUsing methods: ");
        System.out.println("The lowest number to be found in the array is: " + min(dataPoints));
        System.out.println("The highest number to be found in the array is: " + max(dataPoints));

    }

    /**
     * Calculates the average of all the elements in an int array
     *
     * @param values an int array
     * @return the average of all elements in the array
     */
    public static double getAverage(int[] values) {
        double average = 0; // stores average of all values in the array passed in

        // first just add all the values to the average
        for (int i = 0; i < values.length; i++) {
            average += values[i];
        }

        average /= values.length; // the average is now divided by whatever the length of the array is
        return average;
    }


    // extra credit methods:

    /**
     * Finds the smallest value within an int array
     *
     * @param values int array to be tested
     * @return min value found in the array
     */
    public static int min(int[] values) {
        int min = values[0]; // set the min to the first element in the array

        // iterate over length of array, starting with the second element
        for (int i = 1; i < values.length; i++) {

            // if the value at the current index is less than the current min, make it the new min
            if (values[i] <= min) {
                min = values[i];
            }
        }
        return min;
    }

    /**
     * Finds the largest value within an int array
     *
     * @param values int array to be tested
     * @return max value found in the array
     */
    public static int max(int[] values) {
        int max = values[0]; // set the max to the first element in the array

        // iterate over array, starting with second element
        for (int i = 1; i < values.length; i++) {

            // if the current value is greater than or equal to the current max, make it the new max
            if (values[i] >= max) {
                max = values[i];
            }
        }
        return max;
    }

    /**
     * Counts the number of times a value occurs within an int array
     *
     * @param values int array to be tested
     * @param target value to look for within the array
     * @return the number of times the target is found within the array
     */
    public static int occurrenceScan(int[] values, int target) {
        int counter = 0; // number of times found

        // iterate over length of array
        for (int i = 0; i < values.length; i++) {

            // if the current element matches the target, add one to the counter
            if (values[i] == target) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Adds up every element in an int array
     *
     * @param values int array to be tested
     * @return the sum of all elements in the array
     */
    public static int sum(int[] values) {
        int total = 0; // stores sum of all values

        // iterate over array. for each element, add it to the total
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total;
    }

    /**
     * Checks whether an int array contains a specific value
     *
     * @param values int array to be tested
     * @param target value to look for within the array
     * @return true if the array contains the target value
     */
    public static boolean contains(int[] values, int target) {
        boolean targetFound = false; // stores whether the target was found

        // iterate over array
        for (int i = 0; i < values.length; i++) {

            // if the current element matches the target, break the loop and return true
            if (values[i] == target) {
                targetFound = true;
                break;
            }
        }
        return targetFound;
    }
}
