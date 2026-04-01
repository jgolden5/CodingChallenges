package Codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    String t1 = CamelCase.camelCase("testInput");
    if(t1.equals("test Input")) {
      System.out.println("Test passed! Good job :)");
    } else {
      System.out.println("Test failed... :(");
    }
  }
}
