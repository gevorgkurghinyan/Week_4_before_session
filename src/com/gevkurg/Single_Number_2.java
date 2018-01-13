package com.gevkurg;

import java.util.List;


public class Single_Number_2 {
  public int singleNumber(final List<Integer> a) {
    if (a == null) {
      throw new IllegalArgumentException("a");
    }

    int result = 0;
    for(int i = 0; i < 32; ++i) {
      int k = 0;
      for (int j = 0; j < a.size(); ++j) {
        if (((a.get(j) >> i) & 1) == 1) {
          k++;
          k %= 3;
        }
      }

      result |= k << i;
    }

    return result;
  }
}
