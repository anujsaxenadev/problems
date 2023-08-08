package recursion;

public class PowerOf3 {
    public static boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        else if(n == 0 || n % 3 != 0){
            return false;
        }
        return isPowerOfThree(n / 3);
    }
    public static void main(String[] args){
        System.out.println(String.valueOf(isPowerOfThree(9)));
    }
}
