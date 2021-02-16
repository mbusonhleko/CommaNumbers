import java.util.ArrayList;
import java.util.List;

import numberrangesummarizer.NumberRangeSummarizer;

import java.util.Arrays;
import java.util.Collection;

public class Sequential implements NumberRangeSummarizer {

    public static void main(String... args) {
        int[] myList = { 28, 27, 26, 24, 15, 30, 31, 36, 11, 12, 9, 10, 1, 4, 3, 5, 2 };
        int[] myList2 = { 1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31 };

        // Sort this list to be in order
        Arrays.sort(myList2);

        // Create a main (top level list)
        List<List<Integer>> mainList = new ArrayList<>();

        // Create a temp list to hold values throughout loops
        List<Integer> tempList = new ArrayList<>();

        // Add the Lowest number to the list so long
        tempList.add(myList2[0]);

        // List starts at 1 due to having values in it
        // Whilst Arrays starts at 0, thus the (+,-) one's
        for (int i = 0; i < myList2.length - 1; i++) {

            if (myList2[i + 1] == myList2[i] + 1) {
                tempList.add(myList2[i + 1]);
                System.out.println(tempList);
            } else {
                mainList.add(tempList);
                tempList = new ArrayList<>();
                tempList.add(myList2[i + 1]);

            }

        }

        mainList.add(tempList);

        System.out.println(mainList);
    }

    @Override
    public Collection<Integer> collect(String input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        // TODO Auto-generated method stub
        return null;
    }

}
