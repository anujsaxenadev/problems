package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllSubsets {

    public static void printAllSubsets(ArrayList<String> givenList, String outpuString){
        if(givenList.isEmpty()){
            System.out.println(outpuString);
            return;
        }
        String firstElement = givenList.remove(0);
        printAllSubsets(givenList, outpuString + firstElement);
        printAllSubsets(givenList, outpuString);
        givenList.add(0, firstElement);
    }

    public static void main(String[] args){
        String givenString = "abc";
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(givenString.split("")));
        printAllSubsets(stringList, "");
    }
}
