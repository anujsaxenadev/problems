package dynamic_programming;

import java.util.ArrayList;

public class CountingBits {

    public static int[] countBits(int n) {
        int[] finalList = new int[n + 1];
        ArrayList<Integer> currentBitArr = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(i == 0){
                currentBitArr.add(0);
                finalList[i] = 0;
            }
            else {
                int remainder = 0;
                int numberOf1ns = finalList[i - 1];
                for(int j = 0; j < currentBitArr.size(); j++){
                    if(currentBitArr.get(j) == 1){
                        currentBitArr.set(j, 0);
                        numberOf1ns--;
                        remainder = 1;
                    }
                    else {
                        currentBitArr.set(j, 1);
                        numberOf1ns++;
                        remainder = 0;
                        break;
                    }
                }
                if(remainder == 1){
                    currentBitArr.add(remainder);
                    numberOf1ns++;
                }
                System.out.println(currentBitArr.toString());
                finalList[i] = numberOf1ns;
            }
        }
        for(Integer ele : finalList){
            System.out.println(ele);
        }
        return finalList;
    }
    public static void main(String[] args){
        countBits(0);
    }
}
