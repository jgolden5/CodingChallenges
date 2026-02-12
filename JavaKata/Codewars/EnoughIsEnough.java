package Codewars;

import java.util.HashMap;
import java.util.Map;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> currentOccurrences = new HashMap<>();
        int[] resultTrailing = new int[elements.length]; //could be shorter, can't be longer
        int resultIndex = 0;
        for(int i = 0; i < elements.length; i++) {
            int currentNumber = elements[i];
            int occurrencesOfCurrentNumber;
            if(currentOccurrences.get(currentNumber) == null) {
                occurrencesOfCurrentNumber = 0;
            } else {
                occurrencesOfCurrentNumber = currentOccurrences.get(currentNumber);
            }
            occurrencesOfCurrentNumber++;
            currentOccurrences.put(currentNumber, occurrencesOfCurrentNumber);
            if(occurrencesOfCurrentNumber <= maxOccurrences) {
                resultTrailing[resultIndex] = currentNumber;
                resultIndex++;
            }
        }
        int[] result = new int[resultIndex];
        for(int i = 0; i < resultIndex; i++) {
            result[i] = resultTrailing[i];
        }
        return result;
    }

}