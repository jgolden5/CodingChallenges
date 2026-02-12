package Codewars;

import java.util.HashSet;
import java.util.Set;

public class Interval {
    public static int sumIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Set<Double> numbers = new HashSet<>();
        for (int[] interval : intervals) {
            for (double num = interval[0] + 0.5; num < interval[1]; num++) {
                numbers.add(num);
            }
        }

        return numbers.size();
    }
//    public static int sumIntervals(int[][] intervals) {
//        int[][] modifiedIntervals = intervals;
//        int sum = 0;
//        for(int i = 0; i < modifiedIntervals.length; i++) {
//            int[] intervalA = modifiedIntervals[i];
//            int lowA = intervalA[0];
//            int highA = intervalA[1];
//            if(lowA != highA) {
//                for(int j = i + 1; j < modifiedIntervals.length; j++) {
//                    int[] intervalB = modifiedIntervals[j];
//                    int lowB = intervalB[0];
//                    int highB = intervalB[1];
//                    if(lowB != highB) {
//                        String intervalCondition = assignIntervalCondition(lowA, highA, lowB, highB);
//                        modifiedIntervals = modifyIntervalsBasedOnIntervalCondition(intervalCondition, i, j, modifiedIntervals);
//                        intervalA = modifiedIntervals[i];
//                        lowA = intervalA[0];
//                        highA = intervalA[1];
//                    }
//                }
//                sum += highA - lowA;
//            }
//        }
//        return sum;
//    }

//    private static String assignIntervalCondition(int lowA, int highA, int lowB, int highB) {
//        String intervalCondition;
//        if (lowB >= lowA && highB <= highA) {
//            intervalCondition = "inside";
//        } else if (lowB >= highA || lowA >= highB) {
//            intervalCondition = "separateFrom";
//        } else if (lowB < lowA && highB < highA) {
//            intervalCondition = "below";
//        } else if (lowA < lowB) {
//            intervalCondition = "above";
//        } else {
//            intervalCondition = "surrounding";
//        }
//        return intervalCondition;
//    }
//
//    private static int[][] modifyIntervalsBasedOnIntervalCondition(String intervalCondition, int i, int j, int[][] modifiedIntervals) {
//        switch (intervalCondition) {
//            case "inside":
//                modifiedIntervals[j] = new int[]{0, 0};
//                break;
//            case "separateFrom":
//                break;
//            case "below":
//                int lowB = modifiedIntervals[j][0];
//                int highA = modifiedIntervals[i][1];
//                modifiedIntervals[j] = new int[]{lowB, highA};
//                modifiedIntervals[i] = new int[]{0, 0};
//                break;
//            case "above":
//                int lowA = modifiedIntervals[i][0];
//                int highB = modifiedIntervals[j][1];
//                modifiedIntervals[j] = new int[]{lowA, highB};
//                modifiedIntervals[i] = new int[]{0, 0};
//                break;
//            case "surrounding":
//                modifiedIntervals[i] = new int[]{0, 0};
//                break;
//            default:
//                System.out.println("Error: interval condition not recognized");
//        }
//        return modifiedIntervals;
//    }

}