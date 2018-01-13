package com.gevkurg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Min_Xor_Value {
  public int findMinXor(ArrayList<Integer> a) {
    if (a == null || a.size() == 0) {
      return 0;
    }

    a.sort(Comparator.comparingInt(x -> x));
    int minXor = Integer.MAX_VALUE;

    for(int i = 0; i < a.size() - 1; ++i) {
      minXor = Math.min(minXor, a.get(i) ^ a.get(i+1));
    }

    return minXor;
  }
}
