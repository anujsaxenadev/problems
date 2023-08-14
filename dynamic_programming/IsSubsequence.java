package dynamic_programming;

public class IsSubsequence {
    static int[][] dp = null;
    public static boolean isSubsequence(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length(); j++){
                dp[i][j] = -1;
            }
        }
        return containsSubsequence(s, t, 0, 0);
    }

    public static boolean containsSubsequence(String s, String t, int sIndex, int tIndex){
        if(s.isEmpty()){
            return true;
        }
        if(sIndex < s.length() && tIndex < t.length() && dp[sIndex][tIndex] != -1){
            return dp[sIndex][tIndex] == 1;
        }
        boolean foundNextChar = false;
        for(int i = tIndex; i < t.length(); i++){
            if(t.charAt(i) == s.charAt(sIndex)){
                tIndex = i;
                foundNextChar = true;
                if(sIndex == s.length() - 1){
                    dp[sIndex][tIndex] = 1;
                    return true;
                }
                else {
                    boolean caseTaken = containsSubsequence(s, t, sIndex + 1, tIndex + 1);
                    if(sIndex + 1 < s.length() && tIndex + 1 < t.length()){
                        dp[sIndex + 1][tIndex + 1] = caseTaken ? 1 : 0;
                    }
                    if(caseTaken){
                        return true;
                    }
                    boolean caseRejected = containsSubsequence(s, t, sIndex, tIndex + 1);
                    if(tIndex + 1 < t.length()){
                        dp[sIndex][tIndex + 1] = caseRejected ? 1 : 0;
                    }
                    return caseRejected;
                }
            }
        }
        return foundNextChar;
    }

    public static void main(String[] args){
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
