package Codewars;

public class TrailingZerosOfFactorial {
    public static int factorial(int n) {
        if(n < 0) {
            System.out.println("n is negative, therefore factorial is undefined");
            return -1;
        } else if(n > 1) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }
    public static int countDigits(int n) {
        return n >= 0 ? String.valueOf(factorial(n)).length() : 0;
    }

    //only needed this method for kata
    public static int zeros(int n) {
        int z = 0;
        int i = 1;
        while(n >= Math.pow(5, i)) {
            z += Math.floor(n / Math.pow(5, i));
            i++;
        }
        return z;
    }
}
