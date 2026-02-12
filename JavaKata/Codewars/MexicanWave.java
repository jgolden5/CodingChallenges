package Codewars;

public class MexicanWave {
  public static String[] wave(String str) {
    int length = str.length();
    String strCopyWithoutSpaces = str.replaceAll("\\s", "");
    String[] wave = new String[strCopyWithoutSpaces.length()];
    int waveIndex = 0;
    for(int strIndex = 0; strIndex < length; strIndex++) {
      if(str.charAt(strIndex) != ' ') {
        String stringBeforeCapital = str.substring(0, strIndex);
        char capitalizedChar = Character.toUpperCase(str.charAt(strIndex));
        String stringAfterCapital = strIndex < length - 1 ? str.substring(strIndex + 1) : "";
        wave[waveIndex] = stringBeforeCapital + capitalizedChar + stringAfterCapital;
        waveIndex++;
      }
    }
    return wave;
  }
}
