package Codewars;

public class DuplicateEncoder {
    static String encode(String word) {
        //'(' = single occurance char
        //')' = duplicate char (case insensitive)
        String lowerCaseWord = word.toLowerCase();
        String[] encodedArr = new String[lowerCaseWord.length()];
        for(int i = 0; i < lowerCaseWord.length(); i++) {
            for(int j = i + 1; j < lowerCaseWord.length(); j++) {
                if (lowerCaseWord.charAt(i) == lowerCaseWord.charAt(j)) {
                    encodedArr[i] = ")";
                    encodedArr[j] = ")";
                    break;
                }
            }
            if(encodedArr[i] == null) {
                encodedArr[i] = "("; //single match
            }
        }
        String encoded = "";
        for(String s : encodedArr) {
            encoded += s;
        }
//        System.out.println("encoded result = " + encoded);
        return encoded;
    }
}
