package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++){
            List<Integer> currentList = new ArrayList<>();
            if(i == 0){
                currentList.add(1);
            }
            else if(i == 1){
                currentList.add(1);
                currentList.add(1);
            }
            else {
                List<Integer> lastList = finalList.get(i - 1);
                for(int j = 0; j <= lastList.size(); j++){
                    if(j == 0 || j == lastList.size()){
                        currentList.add(1);
                    }
                    else {
                        currentList.add(lastList.get(j - 1) + lastList.get(j));
                    }
                }
            }
            finalList.add(currentList);
        }
        return finalList;
    }

    public static void main(String[] args){
       generate(5);
    }
}
