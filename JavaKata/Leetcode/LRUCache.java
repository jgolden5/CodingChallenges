package Leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

  private int capacity;

  public LRUCache(int capacity) {
    super(capacity, 0.75f, true);
  }

  @Override  
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }

}

/*
Constraints:
1 <= capacity <= 3000
0 <= key <= 10^4
0 <= value <= 10^5
At most 2 * 10^5 calls will be made to get and put.
*/
