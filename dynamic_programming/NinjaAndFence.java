package dynamic_programming;

public class NinjaAndFence {
    private static int MOD = 1000000007;
    private static int numberOfWays(int n, int k) {
        return findNumberOfWaysRec(n, k);
    }

    private static int add(int a, int b){
        return (a % MOD + b % MOD) % MOD;
    }

    private static int mul(int a, int b){
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    

    private static int findNumberOfWaysRec(int n, int k){
        if(n == 1){
            return k;
        }
        else if(n == 2){
            return mul(k, k);
        }
        return add(mul(k - 1, findNumberOfWaysRec(n - 1, k)), mul(k - 1, findNumberOfWaysRec(n - 2, k)));
    }

    public static void main(String[] args){
        System.out.println((numberOfWays(3,2)));
    }
}
