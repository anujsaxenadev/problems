package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationWithSpaces {
    public static void printAllSpacePermutations(ArrayList<String> inputArr, String outputString){
        if(inputArr.isEmpty()){
            System.out.println(outputString);
            return;
        }
        String firstChar =  inputArr.remove(0);
        if(!outputString.isEmpty()){
            printAllSpacePermutations(inputArr, outputString + "_" + firstChar);
        }
        printAllSpacePermutations(inputArr, outputString + firstChar);
        inputArr.add(0, firstChar);
    }

    public static void main (String[] args){
        String inputString = "ABC";
        ArrayList<String> inputArr = new ArrayList<>(Arrays.asList(inputString.split("")));
        printAllSpacePermutations(inputArr, "");
    }
}
