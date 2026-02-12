package Codewars;

import java.util.Arrays;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        System.out.println(Arrays.toString(walk));
        char lastChar = ' ';
        int blocksTraversed = 0;
        int xCoordinate = 0; //east west
        int yCoordinate = 0; //north south
        for(int i = 0; i < walk.length; i++) {
            switch(walk[i]) {
                case 'n':
                    yCoordinate += 1;
                    break;
                case 's':
                    yCoordinate -= 1;
                    break;
                case 'e':
                    xCoordinate += 1;
                    break;
                case 'w':
                    xCoordinate -= 1;
                    break;
                default:
                    System.out.println("Direction not recognized");

            }
        }
        return walk.length == 10 && xCoordinate == 0 && yCoordinate == 0;
    }
}