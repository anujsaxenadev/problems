package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        HashSet<String> paranthasisSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(i == 0){
                paranthasisSet.add("()");
            }
            else {
                HashSet<String> updatedParanthasisSet = new HashSet<>();
                for(String paranthasisSetValue: paranthasisSet){
                    for(int j = 0; j < paranthasisSetValue.length(); j++){
                        updatedParanthasisSet.add(paranthasisSetValue.substring(0, j) + "()" + paranthasisSetValue.substring(j, paranthasisSetValue.length()));
                    }
                }
                paranthasisSet = updatedParanthasisSet;
            }
        }
        return new ArrayList<String>(paranthasisSet);
    }

    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }
}
