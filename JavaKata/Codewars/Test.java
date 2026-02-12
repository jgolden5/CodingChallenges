package Codewars;

public class Test {
  public static long findNextSquare(long sq) {
    double sqrt = Math.sqrt(sq);
    long nextSquare;
    if ((int) sqrt != sqrt) {
      nextSquare = -1;
    } else {
      long rounded = Math.round(sqrt);
      long nextSqrt = rounded + 1;
      nextSquare = nextSqrt * nextSqrt;
    }
    return nextSquare;
  }
}
