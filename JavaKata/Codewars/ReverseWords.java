package Codewars;

public class ReverseWords {
    public static String reverseWords(final String original) {
        for(int h = 0; h < original.length(); h++) {
            if(original.charAt(h) != ' ') {
                break;
            } else if(h == original.length() - 1) {
                return original;
            }
        }
        String[] strArr = original.split(" ");
        String backwards = "";
        for(int i = 0; i < strArr.length; i++) {
            for(int j = strArr[i].length() - 1; j >= 0; j--) {
                backwards += strArr[i].charAt(j);
            }
            if(i < strArr.length - 1) {
                backwards += " ";
            }
        }
        return backwards;
    }
}
