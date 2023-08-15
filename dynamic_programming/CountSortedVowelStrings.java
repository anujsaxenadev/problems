package dynamic_programming;

public class CountSortedVowelStrings {
    
    public static int countVowelStrings(int n) {
        int[] vovelValues = new int[]{1,1,1,1,1};
        if(n > 1){
            int i = 2;
            while(i <= n){
                int rightSum = 1;
                for(int j = vovelValues.length - 2; j >= 0; j--){
                    rightSum += vovelValues[j];
                    vovelValues[j] = rightSum;
                }
                i++;
            }
        }
        int result = 0;
        for(int i = 0; i < vovelValues.length; i++){
            result += vovelValues[i];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(countVowelStrings(33));
    }

}
