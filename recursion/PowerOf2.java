package recursion;

public class PowerOf2 {
    static public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        else if(n == 0 || n % 2 != 0){
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
    public static void main(String[] args){
        System.out.println(String.valueOf(isPowerOfTwo(0)));
    }
}
