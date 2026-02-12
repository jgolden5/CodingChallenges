package Codewars;

//Note: Technically this is a "leetcode" problem, not codewars, but y'know...
public class RomanToInteger { //rename to Solution before submitting
    public static int RomanToInt(String s) { //also make this non-static
        int answer = 0;
        Character lastChar = ' ';
        for(int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            Character nextChar = i < s.length() - 1 ? s.charAt(i + 1) : ' ';
            switch (currentChar) {
                case 'I':
                    if (nextChar != 'V' && nextChar != 'X') {
                        answer += 1;
                    }
                    lastChar = 'I';
                    break;
                case 'V':
                    if(lastChar == 'I') {
                        answer += 4;
                    } else {
                        answer += 5;
                    }
                    lastChar = 'V';
                    break;
                case 'X':
                    if(lastChar == 'I') {
                        answer += 9;
                    } else if(nextChar != 'L' && nextChar != 'C') {
                        answer += 10;
                    }
                    lastChar = 'X';
                    break;
                case 'L':
                    if(lastChar == 'X') {
                        answer += 40;
                    } else {
                        answer += 50;
                    }
                    lastChar = 'L';
                    break;
                case 'C':
                    if(lastChar == 'X') {
                        answer += 90;
                    } else if(nextChar != 'D' && nextChar != 'M') {
                        answer += 100;
                    }
                    lastChar = 'C';
                    break;
                case 'D':
                    if(lastChar == 'C') {
                        answer += 400;
                    } else {
                        answer += 500;
                    }
                    lastChar = 'D';
                    break;
                case 'M':
                    if(lastChar == 'C') {
                        answer += 900;
                    } else {
                        answer += 1000;
                    }
                    lastChar = 'M';
                    break;
                default:
                    System.out.println("Roman numeral " + currentChar + " not found");
            }
        }
        return answer;
    }
}
