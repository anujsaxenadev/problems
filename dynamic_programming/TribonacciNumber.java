package dynamic_programming;

public class TribonacciNumber {
    public static int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        if(n == 0){
            return t0;
        }
        else if(n == 1){
            return t1;
        }
        else if(n == 2){
            return t2;
        }
        else {
            for(int i = 3; i <= n; i++){
                int nextNumber = t0 + t1 + t2;
                t0 = t1;
                t1 = t2;
                t2 = nextNumber;
                if(i == n){
                    return nextNumber;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(tribonacci(6));
    }
}
