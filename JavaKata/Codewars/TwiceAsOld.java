package Codewars;

public class TwiceAsOld{



    public static int TwiceAsOld(int dadYears, int sonYears) {
        int targetSon = sonYears * 2;
        int answer = targetSon > dadYears ? targetSon - dadYears : dadYears - targetSon;
        return answer;
    }

}

//codewars passed ✅