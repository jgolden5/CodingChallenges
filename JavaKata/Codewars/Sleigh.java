package Codewars;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Map;

//code by Madjosz on https://www.codewars.com/kata/52adc142b2651f25a8000643/solutions/java
public class Sleigh {
  public static Boolean authenticate(String name, String password) {
    // Do not store plaintext passwords! Compare hashes instead.
    String hash = USER_DB.get(name);
    if(hash == null) return false; // TODO no fast fail, could be exploited for user scanning
    try {
      return validate(password.toCharArray(), hash);
    } catch(GeneralSecurityException e) {
      throw new IllegalStateException("Could not validate password.", e);
    }
  }

  private static boolean validate(char[] password, String hash) throws GeneralSecurityException {
    String[] parts = hash.split(":");
    byte[] salt = readBytes(parts[0]);
    byte[] encoded = readBytes(parts[1]);
    return Arrays.equals(encoded, hash(password, salt));
  }

  private static byte[] hash(char[] password, byte[] salt) throws GeneralSecurityException {
    // use PBKDF2 as it is more secure than MD5 or SHA-256
    KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    return factory.generateSecret(spec).getEncoded();
  }

  private static byte[] readBytes(String hex) {
    byte[] bytes = new byte[hex.length() / 2];
    for (int i = 0; i < bytes.length; ++i)
      bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
    return bytes;
  }

  // TODO extract this into a database
  private static Map<String,String> USER_DB = Map.of(
    "Santa Claus", "393987BBED1FECD441C260EAAEF2C902:7F98FD4D94CF1B1B9F17D042818A9AF3");
}
