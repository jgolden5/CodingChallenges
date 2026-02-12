package Codewars;

import java.util.ArrayList;

public class ParityOutlier {
    static int find(int[] integers) {
        ArrayList<Integer> odds = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();
        for(int i = 0; i < integers.length; i++) {
            if(integers[i] % 2 == 0) {
                evens.add(integers[i]);
            } else {
                odds.add(integers[i]);
            }
            if(i >= 2) {
                if(odds.size() > 0 && evens.size() > odds.size()) {
                    return odds.get(0);
                } else if(evens.size() > 0 && odds.size() > evens.size()) {
                    return evens.get(0);
                }
            }
        }
        return -1;
    }
}

