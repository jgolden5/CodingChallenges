package Codewars;

public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        int i = 0;
        int intToConvert;
        String hex = "";
        while(i < 3) {
            if (i == 0) {
                intToConvert = r;
            } else if (i == 1) {
                intToConvert = g;
            } else {
                intToConvert = b;
            }
            if (intToConvert > 255) {
                hex += "FF";
            } else if(intToConvert < 0) {
                hex += "00";
            } else {
                int firstDigit = (int) Math.floor(intToConvert / 16);
                int secondDigit = intToConvert - firstDigit * 16;
                int[] digits = new int[]{firstDigit, secondDigit};
                int j = 0;
                while (j < 2) {
                    if (digits[j] < 10) {
                        hex += Integer.valueOf(digits[j]);
                    } else {
                        switch (digits[j]) {
                            case 10:
                                hex += "A";
                                break;
                            case 11:
                                hex += "B";
                                break;
                            case 12:
                                hex += "C";
                                break;
                            case 13:
                                hex += "D";
                                break;
                            case 14:
                                hex += "E";
                                break;
                            case 15:
                                hex += "F";
                                break;
                            default:
                                System.out.println("invalid digit value");
                        }
                    }
                    j++;
                }
            }
            i++;
        }
        return hex;
    }
}
