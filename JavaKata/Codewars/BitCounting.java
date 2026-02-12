package Codewars;

public class BitCounting {
    public static int countBits(int n) {
        int b = 0;
        int ones = 0;
        while(n >= Math.pow(2.0, Double.valueOf(b))) {
            b++;
        }
        for(int i = 0; b > 0; i++) {
            if(n >= Math.pow(2.0, Double.valueOf(b - 1.0))) {
                n -= Math.pow(2.0, Double.valueOf(b - 1.0));
                ones++;
            }
            b--;
        }
        return ones;
    }
}
