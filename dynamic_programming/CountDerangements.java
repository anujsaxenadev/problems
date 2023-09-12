package dynamic_programming;

public class CountDerangements {
    public static long countDerangements(int n) {
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        else {
            return (n - 1) * (countDerangements(n - 2) + countDerangements(n - 1));
        }
	}
    public static void main(String[] args){
        System.out.println(countDerangements(4));
    }
}
