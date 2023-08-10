package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationWithCaseChangeWithDigits {
    public static void printPermutationWithCaseChangeWithDigits(ArrayList<String> inputList, String outputString){
        if(inputList.isEmpty()){
            System.out.println(outputString);
            return;
        }
        String firstElement = inputList.remove(0);
        String switchString = "";
        try{
            Integer.parseInt(firstElement);
            printPermutationWithCaseChangeWithDigits(inputList, outputString + firstElement);
        }
        catch(Exception e){
            char givenChar = firstElement.charAt(0);
            if(Character.isUpperCase(givenChar)){
                switchString = switchString + Character.toLowerCase(givenChar);
            }
            else {
                switchString = switchString + Character.toUpperCase(givenChar);
            }
            printPermutationWithCaseChangeWithDigits(inputList, outputString + firstElement);
            printPermutationWithCaseChangeWithDigits(inputList, outputString + switchString);
        }
        inputList.add(0, firstElement);
    }

    public static void main(String[] args){
        String inputString = "aB1c";
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(inputString.split("")));
        printPermutationWithCaseChangeWithDigits(inputList, "");
    }
}
