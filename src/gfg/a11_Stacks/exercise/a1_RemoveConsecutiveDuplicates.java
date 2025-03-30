package gfg.a11_Stacks.exercise;

import java.util.Stack;

public class a1_RemoveConsecutiveDuplicates {
  public static void main(String[] args) {
    String str = "aaaabbbaabbbccccc";
    System.out.println(removeConsecutiveDuplicates(str));

    String str1 = "aaabbaaccd";
    System.out.println(removePair(str1));
  }

  private static String removePair(String s) {
    Stack stack = new Stack();
    stack.add(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      if (stack.isEmpty()) {
        stack.add(s.charAt(i));
      } else if ((char) stack.peek() != s.charAt(i)) {
        stack.add(s.charAt(i));
      } else {
        stack.pop();
      }
    }
    if (stack.isEmpty()) {
      return "Empty String";
    }

    String str = new String();
    for (int i = 0; i < stack.size(); i++) {
      str += stack.get(i);
    }
    return str;
  }

  private static String removeConsecutiveDuplicates(String s) {
    Stack stack = new Stack();
    stack.add(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      if ((char) stack.peek() != s.charAt(i)) {
        stack.add(s.charAt(i));
      }
    }
    String str = new String();
    for (int i = 0; i < stack.size(); i++) {
      str += stack.get(i);
    }
    return str;
  }
}
