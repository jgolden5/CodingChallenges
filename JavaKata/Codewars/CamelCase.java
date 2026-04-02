package Codewars;

class CamelCase {
  
  public static String camelCase(String input) {
    String res = "";
    for(int i = 0; i < input.length(); i++) {
      char currentChar = input.charAt(i);
      if(isUppercase(currentChar)) {
        res += " " + currentChar;
      } else {
        res += currentChar;
      }
    }
    return res;
  }
  
  public static boolean isUppercase(char c) {
    return (int) c >= 65 && c <= 90;
  }
  
}
