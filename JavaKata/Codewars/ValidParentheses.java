package Codewars;

public class ValidParentheses {
    public static boolean validParentheses(String parenStr) {
        int pTracker = 0;
        for(int i = 0; i < parenStr.length(); i++) {
            if(parenStr.charAt(i) == '(') {
                pTracker += 1;
            } else if(parenStr.charAt(i) == ')') {
                if(pTracker >= 1) {
                    pTracker--;
                } else {
                    return false;
                }
            }
        }
        return pTracker == 0;
    }
}
