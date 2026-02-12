package Codewars;

import java.util.ArrayList;

public class EasyKata {

  public static ArrayList<Integer> getOrderedEvens(ArrayList<Integer> randomInts) {
    ArrayList<Integer> evenInts = extractEvens(randomInts);
    return bubbleSort(evenInts);
  }

  private static ArrayList<Integer> bubbleSort(ArrayList<Integer> evenInts) {
    for(int i = 0; i < evenInts.size() - 1; i++) {
      int left = evenInts.get(i);
      int right = evenInts.get(i + 1);
      if(left > right) {
        swapElements(evenInts, i);
      }
    }
    return evenInts;
  }

  private static ArrayList<Integer> extractEvens(ArrayList<Integer> randomInts) {
    ArrayList<Integer> evenInts = new ArrayList<>();
    for(int r : randomInts) {
      if(r % 2 == 0) {
        evenInts.add(r);
      }
    }
    return evenInts;
  }

  //mutating func
  private static void swapElements(ArrayList<Integer> original, int i) {
    int right = original.remove(i);
    int left = original.remove(i);
    original.add(i, right);
    original.add(i, left);
  }

}
