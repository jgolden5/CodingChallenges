package Codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] a1 = {1, 2, 3};
    int[] r1 = {2, 3};
    int[] a2 = {5, 4};
    int[] r2 = {5};
    int[] a3 = {6, 7, 6, 8};
    int[] r3 = {7, 6, 8};
    int[] a4 = {};
    int[] r4 = {};
    int[] a5 = {9, 8, 7, 10};
    int[] r5 = {9, 8, 10};
    System.out.println(Arrays.equals(Remover.removeSmallest(a1), r1));
    System.out.println(Arrays.equals(Remover.removeSmallest(a2), r2));
    System.out.println(Arrays.equals(Remover.removeSmallest(a3), r3));
    System.out.println(Arrays.equals(Remover.removeSmallest(a4), r4));
    System.out.println(Arrays.equals(Remover.removeSmallest(a5), r5));
  }
}
