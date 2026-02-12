package Codewars;

public class Snail {
  public static int[] snail(int[][] slug) {
    final int n = slug[0].length;
    int[] snail;
    if(n == 1) {
      snail = new int[]{slug[0][0]};
    } else if(n == 0) {
      snail = new int[]{};
    } else {
      snail = new int[n * n];
      int max = n - 1;
      int min = 0;
      int i = 0;
      while (i < n * n) {
        snail = slug_to_snail(slug, snail, i, new int[][]{new int[]{min}, new int[]{min, max}});
        i += max - min + 1;
        if (i + max - (min + 1) + 1 == n * n - 1) {
          snail = slug_to_snail(slug, snail, i, new int[][]{new int[]{max}, new int[]{min + 1, max}});
          break;
        } else {
          snail = slug_to_snail(slug, snail, i, new int[][]{new int[]{min + 1, max}, new int[]{max}});
          i += max - (min + 1) + 1;
        }
        snail = slug_to_snail(slug, snail, i, new int[][]{new int[]{max--}, new int[]{max, min}});
        i += max - min + 1;
        if (i + (max - min) == n * n - 1) {
          snail = slug_to_snail(slug, snail, i, new int[][]{new int[]{min + 1}, new int[]{min, max}});
          i += max - min + 1;
        } else {
          snail = slug_to_snail(slug, snail, i, new int[][]{new int[]{max, min + 1}, new int[]{min++}});
          i += max - min + 1;
        }
      }
    }
    return snail;
  }

  private static int[] slug_to_snail(int[][] slug, int[] snail, int i, int[][] snailifier) {
    int var_section_of_snailifier = snailifier[0].length > 1 ? 0 : 1;
    int const_section_of_snailifier = var_section_of_snailifier == 0 ? 1 : 0;
    int incrementer = snailifier[var_section_of_snailifier][0] < snailifier[var_section_of_snailifier][1] ? 1 : -1;
    if(snailifier[var_section_of_snailifier][0] == snailifier[var_section_of_snailifier][1]) {
      snailifier[var_section_of_snailifier][1]--;
    }
    if(var_section_of_snailifier == 1) {
      while (true) {
        snail[i++] = slug[snailifier[const_section_of_snailifier][0]][snailifier[var_section_of_snailifier][0]];
        snailifier[var_section_of_snailifier][0] += incrementer;
        if (snailifier[var_section_of_snailifier][0] - incrementer == snailifier[var_section_of_snailifier][1]) {
          break;
        }
      }
    } else {
      while (true) {
        snail[i++] = slug[snailifier[var_section_of_snailifier][0]][snailifier[const_section_of_snailifier][0]];
        snailifier[var_section_of_snailifier][0] += incrementer;
        if (snailifier[var_section_of_snailifier][0] - incrementer == snailifier[var_section_of_snailifier][1]) {
          break;
        }
      }
    }
    return snail;
  }

}
