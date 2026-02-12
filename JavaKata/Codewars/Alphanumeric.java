package Codewars;

public class Alphanumeric {
    public static boolean alphanumeric(String s) {
        String alphanumerals = "abcdefghijklmnopqrstuvwxyz1234567890";
        if(s.length() == 0) {
            return false;
        } else {
            String[] sArr = s.split("");
            for (int i = 0; i < sArr.length; i++) {
                if (!alphanumerals.contains(sArr[i].toLowerCase())) {
                    return false;
                }
            }
            return true;
        }
    }
}
