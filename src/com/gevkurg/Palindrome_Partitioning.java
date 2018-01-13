package com.gevkurg;

import java.util.ArrayList;


public class Palindrome_Partitioning {
  public static ArrayList<ArrayList<String>> partition(String a) {
    if (a == null || a.length() == 0) {
      return null;
    }

    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    ArrayList<String> list = new ArrayList<String>();
    partition(a, 0, result, list);
    return result;
  }

  private static void partition(String s, int i, ArrayList<ArrayList<String>> result,
      ArrayList<String> list) {
    if (list.size() >= 0 && i >= s.length()) {
      result.add(new ArrayList<String>(list));
      return;
    }

    for(int j = i; j < s.length(); ++j) {
      if (isPalindrome(s, i, j)){
        if (i == j){
          list.add(Character.toString(s.charAt(i)));
        } else {
          list.add(s.substring(i, j + 1));
        }

        partition(s, j + 1, result, list);
        list.remove(list.size() - 1);
      }
    }
  }

  private static boolean isPalindrome(String s, int i, int j) {
    if (s == null || s.length() <= 1) {
      return true;
    }

    while(i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }

      ++i;
      --j;
    }

    return true;
  }
}
