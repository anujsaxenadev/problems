package recursion;

public class KthSymbolGrammer {
    
    static int kthGrammar(int n, int k){
        if(k == 1){
            return 0;
        }
        else {
            int size = (int) Math.pow(2, n - 1);
            if(k > size){
                return -1;
            }
            int mid = size / 2;
            if(mid >= k){
                return kthGrammar(n - 1, k);
            }
            else {
                int result = kthGrammar(n - 1, k - mid);
                if(result == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        }
    }

    public static void main(String[] args){
        System.out.println(kthGrammar(4,9));
    }
}
