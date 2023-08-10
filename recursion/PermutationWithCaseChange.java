package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationWithCaseChange {
    public static void printPermutationWithCaseChange(ArrayList<String> givenList, String outputString){
        if(givenList.isEmpty()){
            System.out.println(outputString);
            return;
        }
        String firstElement = givenList.remove(0);
        printPermutationWithCaseChange(givenList, outputString + firstElement);
        printPermutationWithCaseChange(givenList, outputString + firstElement.toUpperCase());
        givenList.add(0, firstElement);
    }

    public static void main(String[] args){
        String inputString = "abc";
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(inputString.split("")));
        printPermutationWithCaseChange(inputList, "");
    }
}
