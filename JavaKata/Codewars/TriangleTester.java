package Codewars;

class TriangleTester {
  public static boolean isTriangle(int a, int b, int c) {
    int longSide;
    int shortSide1;
    int shortSide2;
    if(a > b && a > c) {
      longSide = a;
      shortSide1 = b;
      shortSide2 = c;
    } else if(b > a && b > c) {
      longSide = b;
      shortSide1 = a;
      shortSide2 = c;
    } else {
      longSide = c;
      shortSide1 = a;
      shortSide2 = b;
    }
    boolean sidesArePositive =  longSide > 0 && shortSide1 > 0 && shortSide2 > 0;
    return longSide < shortSide1 + shortSide2 && sidesArePositive;
  }
}

//solved in 12 minutes