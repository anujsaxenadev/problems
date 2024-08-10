package patterns;

/**
 * 
 *  Problem statement
    Sam is making a forest visualizer. An N-dimensional forest is represented by the pattern of size NxN filled with ‘*’.

    For every value of ‘N’, help sam to print the corresponding N-dimensional forest.

    Example:
    Input: ‘N’ = 3

    Output: 
    * * *
    * * *
    * * *
 */

public class Pattern1 {
    public static void main(String[] args) {
        int n = 10;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
