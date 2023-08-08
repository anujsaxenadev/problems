package recursion;

public class PowerOf4 {
    static public boolean isPowerOfFour(int n) {
        if(n == 1){
            return true;
        }
        else if(n == 0 || n % 4 != 0){
            return false;
        }
        return isPowerOfFour(n / 4);
    }
    public static void main(String[] args){
        System.out.println(String.valueOf(isPowerOfFour(6)));
    }
}
