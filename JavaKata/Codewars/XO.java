package Codewars;

public class XO {

    public static boolean getXO (String str) {

        int xCount = 0;
        int oCount = 0;

        for(int i = 0; i < str.length(); i++) {
            char characterBeingObserved = Character.toLowerCase(str.charAt(i));
            if(characterBeingObserved == 'x') {
                xCount++;
            } else if(characterBeingObserved == 'o') {
                oCount++;
            }
        }

        return xCount == oCount;

    }

}