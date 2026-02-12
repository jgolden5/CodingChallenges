package Codewars;

public class SumArray {
    public static double sum(double[] numbers) {
        double sum = 0;
        for(double n : numbers) {
            sum += n;
        }
        return sum;
    }
}
//Codewars passed ✅