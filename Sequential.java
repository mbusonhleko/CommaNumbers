import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Werner
 *
 *         Implement this Interface to produce a comma delimited list of
 *         numbers, grouping the numbers into a range when they are sequential.
 *
 *
 *         Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31 Result: "1, 3,
 *         6-8, 12-15, 21-24, 31"
 *
 *         The code will be evaluated on - functionality - style - robustness -
 *         best practices - unit tests


 * Notes from Reviewer:
 * - you created a package and then only stuck the provided interface in there... all your files should be within this package
 * - duplicated the provided interface code in your implementation. DRY -> Don't Repeat Yourself
 * - Bundling 2 classes in one file ..
 * - No unit tests. Not even an attempt. This was a hard requirement.
 * - Your assumptions in the readme should be part of your unit tests.
 * - Code not written in Java 8. This was also a requirement, though maybe not as hard as the unit tests.
 * - Your implementation itself is actually quite good. Sanitizing input, sorting, etc. Such a shame about the rest!
 */

interface NumberRangeSummarizer {

    // collect the input
    Collection<Integer> collect(String input);

    // get the summarized string
    String summarizeCollection(Collection<Integer> input);

}

/**
 * The Sequential program implements the NumberRangeSummarizer in order to
 * produce a comma delimited list of numbers, grouping the numbers into a range
 * when they are sequential.
 *
 * @author Dian van Deventer
 */

public class Sequential implements NumberRangeSummarizer {
    private Collection<Integer> col;
    private String answer;

    public Sequential() {
        this.col = new ArrayList<>();
        this.answer = "";
    }

    public Collection<Integer> getCol() {
        return this.col;
    }

    public String getAnswer() {
        return this.answer;
    }

    public static void main(String... args) {
        Sequential seq = new Sequential();
        String userIn = "";
        Scanner keyboard = new Scanner(System.in);

        while (!userIn.equals("0")) {
            System.out.println("Enter number (0 to continue):");
            userIn = keyboard.nextLine();
            if (userIn.equals("0")) {
                break;
            }
            if (!(userIn.matches("^[1-9][0-9]*"))) {
                System.out.println("Invalid number");
            } else {
                seq.col = seq.collect(userIn);
            }
        }

        keyboard.close();
        seq.answer = seq.summarizeCollection(seq.col);
        StringBuffer sBuff = new StringBuffer(seq.answer);
        sBuff.deleteCharAt(sBuff.length() - 1);
        System.out.println(sBuff);
    }

    /**
     * Get number values to return a collection of type integer
     * 
     * @param {String} input - The number values entered via the user
     * @return Collection of type integers
     */

    @Override
    public Collection<Integer> collect(String input) {
        this.col.add(Integer.parseInt(input));
        return this.col;
    }

    /**
     * Use a collection of type integer to return a comma delimited string
     * 
     * @param {Collection<Integer>} input - Collection of integers
     * @return Comma delimited string
     */

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        int counter = 0;
        int colSize = input.size();
        int[] myArrList = new int[colSize];

        for (int i = 0; i <= colSize - 1; i++) {
            myArrList[counter] = (int) input.toArray()[counter];
            counter++;
        }

        Arrays.sort(myArrList);
        int arrListLength = myArrList.length;
        int number = 0, number2 = 0;

        while (number < arrListLength) {
            while (++number2 < arrListLength && myArrList[number2] - myArrList[number2 - 1] == 1)
                ;
            if (number2 - number > 2) {
                this.answer = this.answer + String.format("%s-%s,", myArrList[number], myArrList[number2 - 1]);
                number = number2;
            } else {
                for (; number < number2; number++)
                    this.answer = this.answer + String.format("%s,", myArrList[number]);
            }
        }

        return this.answer;
    }

}
