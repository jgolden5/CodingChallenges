package Codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSubarraySum {
    public static int sequence(int[] arr) {
        /*
        if all numbers <= 0, return 0, else
        exclude negative "bookends" (eg. if arr == -5, -2, -5, 5, 3, -2, 7, -5, change it to 5, 3, -2, 7)

        if remaining array contains only positives, return the sum, else

        CASE 1: there only exists 1 negative number excluding bookends

        find each negative in the array (currentNeg), and determine the sum of elements to the left (leftSum) and right (rightSum)
            if leftSum > currentNeg, include leftSum in new arr
            if rightSum > currentNeg, include rightSum in new arr
            if leftSum < currentNeg & rightSum < currentNeg, choose leftSum or rightSum, and consider that the answer


         */
        if(containsOnlyNegatives(arr)) {
            return 0;
        } else {
            arr = excludeNegativeBookends(arr);
            if(containsOnlyPositives(arr)) {
                return sumArray(arr);
            }
        }
        return -1;
    }

    public static boolean containsOnlyNegatives(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyPositives(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] excludeNegativeBookends(int[] arr) {
        ArrayList<Integer> withoutBookends = new ArrayList<>();
        int firstIndex = 0;
        int lastIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                firstIndex = i;
                break;
            }
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > 0) {
                lastIndex = i;
                break;
            }
        }
        for(int i = firstIndex; i <= lastIndex; i++) {
            withoutBookends.add(arr[i]);
        }
        int[] finalArr = new int[withoutBookends.size()];
        for(int i = 0; i < withoutBookends.size(); i++) {
            finalArr[i] = withoutBookends.get(i);
        }
        return finalArr;
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
