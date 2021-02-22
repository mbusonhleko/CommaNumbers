import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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
 */

interface NumberRangeSummarizer {

    // collect the input
    Collection<Integer> collect(String input);

    // get the summarized string
    String summarizeCollection(Collection<Integer> input);

}

public class Sequential implements NumberRangeSummarizer {
    static Collection<Integer> col = new ArrayList<>();
    static String answer = "";

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

                col = seq.collect(userIn);
            }
        }
        keyboard.close();
        answer = seq.summarizeCollection(col);
        System.out.println(answer);

    }

    @Override
    public Collection<Integer> collect(String input) {
        // System.out.println(input);

        col.add(Integer.parseInt(input));

        return col;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        // int[] myArrList = { 1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31 };

        int counter = 0;
        int colSize = input.size();
        // System.out.println("col: " + colSize);
        int[] myArrList = new int[colSize];
        for (int i = 0; i <= colSize - 1; i++) {
            // System.out.println("Array before: " + myArrList[counter]);
            myArrList[counter] = (int) input.toArray()[counter];
            // System.out.println("Array after: " + myArrList[counter]);
            counter++;
        }

        Arrays.sort(myArrList);
        int arrListLength = myArrList.length;
        int number = 0, number2 = 0;

        while (number < arrListLength) {
            while (++number2 < arrListLength && myArrList[number2] - myArrList[number2 - 1] == 1)
                ;
            if (number2 - number > 2) {
                // System.out.printf("%s-%s,", myArrList[number], myArrList[number2 - 1]);
                answer = answer + String.format("%s-%s,", myArrList[number], myArrList[number2 - 1]);
                number = number2;
            } else {
                for (; number < number2; number++)
                    answer = answer + String.format("%s,", myArrList[number]);
                // System.out.printf("%s,", myArrList[number]);
            }
        }

        return answer;
    }

}
