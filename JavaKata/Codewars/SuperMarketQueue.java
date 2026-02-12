package Codewars;

public class SuperMarketQueue {
  public static int solveSuperMarketQueue(int[] customers, int n) {
    int t = 0;
    int[] customersAtTills = getCustomersAtTills(customers, n);
    int[] customersWaiting = getCustomersWaiting(customers, n);

    while(customersWaiting.length > 0) {
      int[][] customersAfterWaiting = getCustomersAfterWaiting(customersWaiting, customersAtTills);
      customersAtTills = customersAfterWaiting[0];
      customersWaiting = customersAfterWaiting[1];
    }

    return t;
  }

  private static int[][] getCustomersAfterWaiting(int[] customersWaiting, int[] customersAtTills) {
    int[][] customersAfterWaiting = new int[2][];
    int[] customersAtTillsAfterWaiting = decrementArray(customersAtTills);
    int[] customersWaitingAfterWaiting = moveLine(customersAtTillsAfterWaiting, customersWaiting);

    customersAfterWaiting[0] = customersAtTillsAfterWaiting;
    customersAfterWaiting[1] = customersWaitingAfterWaiting;
    return customersAfterWaiting;
  }

  private static int[] decrementArray(int[] a) {
    int[] decrementedA = new int[a.length];
    for(int i = 0; i < a.length; i++) {
      decrementedA[i] = a[i] - 1;
    }
    return decrementedA;
  }

  private static int[] moveLine(int[] customersAtTillsAfterWaiting, int[] customersWaiting) {
    int[] customersWaitingAfterWaiting;
    return null;
  }

  private static int[] getCustomersAtTills(int[] customers, int n) {
    int[] customersAtTills = new int[n];
    for(int i = 0; i < n; i++) {
      customersAtTills[i] = customers[i];
    }
    return customersAtTills;
  }

  private static int[] getCustomersWaiting(int[] customers, int n) {
    int[] customersWaiting = new int[customers.length - n];
    int indexOfCustomersWaiting = 0;
    for(int i = n; i < customers.length; i++) {
      customersWaiting[indexOfCustomersWaiting] = customers[i];
      indexOfCustomersWaiting++;
    }
    return customersWaiting;
  }

}
