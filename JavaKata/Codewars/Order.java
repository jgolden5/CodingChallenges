package Codewars;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Order {

  public static String order(String words) {
    String res = "";
    //account for empty string case
    if(words.equals(""))
      return res;
    
    //convert words string to array of words
    String[] wordsSource = words.split(" ");
    String[] wordsResult = new String[wordsSource.length];
    
    //loop through every element of words array and print just the number (as an integer) from each word
    int indexOfDigit;
    String digitsRegex = ".*?(\\d).*";
    Pattern digitPattern = Pattern.compile(digitsRegex);
    for(int i = 0; i < wordsSource.length; i++) {
      String currentWord = wordsSource[i];
      Matcher matcher = digitPattern.matcher(currentWord);
      matcher.matches(); // need to call matches() before accessing group to give context for group
      indexOfDigit = matcher.start(1); //matches group 1, which in our case gives the group of the digit itself
      char digitAsChar = currentWord.charAt(indexOfDigit);
      String digitAsString = Character.toString(digitAsChar);
      int digit = Integer.valueOf(digitAsString);
      wordsResult[digit - 1] = currentWord;
    }
    res = String.join(" ", wordsResult);
    return res;
  }

}

//test status: 92 minutes = DID pass :)
//link: https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java