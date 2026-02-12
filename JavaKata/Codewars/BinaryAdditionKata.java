package Codewars;

public class BinaryAdditionKata { //change class name to Kata when submitting solution

    public static String binaryAddition(int a, int b) { //a = 5, b = 3
        int nonBinarySum = a + b; //8
        int numberOfBinaryDigits = 0;
        while(nonBinarySum >= Math.pow(2, numberOfBinaryDigits)) { //8 >= 2 ** 4
            numberOfBinaryDigits++; // 4
        }
        System.out.println("numberOfBinaryDigits = " + numberOfBinaryDigits);
        
        int remainingToBeBinaried = nonBinarySum;
        String binaryAnswer = "";
        for(int i = numberOfBinaryDigits - 1; i >= 0; i--) {
            if(remainingToBeBinaried >= Math.pow(2, i)) {
                binaryAnswer += "1";
                remainingToBeBinaried -= Math.pow(2, i);
            } else {
                binaryAnswer += "0";
            }
        }
        
        return binaryAnswer;
    }
}
//✅