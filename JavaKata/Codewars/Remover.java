package Codewars;

public class Remover {
  public static int[] removeSmallest(int[] nums) {
    int lowestRatingIndex = getIndexOfSmallest(nums);
    int[] arrayWithoutSmallest = {};
    if(nums.length > 0) {
      arrayWithoutSmallest = getArrayWithoutSmallest(nums, lowestRatingIndex);
    }
    return arrayWithoutSmallest;
  }
  
  private static int getIndexOfSmallest(int[] nums) {
    int lowestRatingIndex = 0;
    if(nums.length > 0) {
      for(int i = 1; i < nums.length; i++) {
        if(nums[i] < nums[lowestRatingIndex]) {
          lowestRatingIndex = i;
        }
      }
    }
    return lowestRatingIndex;
  }

  private static int[] getArrayWithoutSmallest(int[] nums, int lowestRatingIndex) {
    int[] res = new int[nums.length - 1];
    int resIndex = 0;
    for(int i = 0; i < nums.length; i++) {
      if(i != lowestRatingIndex) {
        res[resIndex] = nums[i];
        resIndex++;
      }
    }
    return res;
  }

}
