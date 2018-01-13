package com.gevkurg;

import java.util.ArrayList;
import java.util.Comparator;


public class Combination_Sum {
  public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    if (a == null || a.size() == 0) {
      return null;
    }

    a.sort(Comparator.comparingInt(x -> x));
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    combinationSum(a, 0, list, result, b);
    return result;
  }

  private static void combinationSum(ArrayList<Integer> a, int i, ArrayList<Integer> list,
      ArrayList<ArrayList<Integer>> result, int b) {
    if (b == 0) {
      result.add(new ArrayList<Integer>(list));
      return;
    }

    for(int j = i; j < a.size(); ++j) {
      if ((j == 0 || a.get(j) != a.get(j-1)) && a.get(j) <= b) {
        list.add(a.get(j));
        combinationSum(a, j, list, result, b - a.get(j));
        list.remove(list.size() - 1);
      }
    }
  }
}
