package recursion;

public class SumOfNNumbers {
    static public int getSumOfNNumbers(int n, int sum) {
        if(n <= 0){
            return sum;
        }
        else{
            return getSumOfNNumbers(n - 1, sum + n);
        }
    }

    public static void main(String[] args){
        System.out.println(String.valueOf(getSumOfNNumbers(60000, 0)));
    }
}