package recursion;

import java.util.ArrayList;

public class PrintSubsequences {
    public static void printSubsequences(int[] list, int index, ArrayList<Integer> outputList){
        if(index >= list.length){
            print(outputList);
            return;
        }
        // Take
        outputList.add(list[index]);
        printSubsequences(list, index + 1, outputList);
        // Not Take
        outputList.removeLast();
        printSubsequences(list, index + 1, outputList);

    }

    public static void print(ArrayList<Integer> outputList){
        for(Integer item : outputList){
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        printSubsequences(new int[] {3,1,2}, 0, new ArrayList<>());
    }
}
