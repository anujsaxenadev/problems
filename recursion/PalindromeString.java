package recursion;

public class PalindromeString {
    static boolean isPalindrome(String inputString, int index, int size){
        if(size == 0 || index >= size / 2){
            return true;
        }
        else if(inputString.charAt(index) == inputString.charAt(size - index - 1)){
            return isPalindrome(inputString, index + 1, size);
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        String inputString = "M<<M";
        System.out.println(isPalindrome(inputString, 0, inputString.length()));
    }
}
