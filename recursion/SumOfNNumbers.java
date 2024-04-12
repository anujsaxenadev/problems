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


    static public int getSumOfNNumbers2(int n) {
        if(n <= 0){
            return n;
        }
        else{
            return n + getSumOfNNumbers2(n - 1);
        }
    }

    public static void main(String[] args){
        System.out.println(String.valueOf(getSumOfNNumbers2(3)));
    }
}