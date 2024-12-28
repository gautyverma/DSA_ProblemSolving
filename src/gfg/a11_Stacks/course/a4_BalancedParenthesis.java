package gfg.a11_Stacks.course;

import java.util.ArrayDeque;

public class a4_BalancedParenthesis {
  public static void main(String[] args) {
    String s1 = "({})";
    String s2 = "([{}])}";
    System.out.println("s1: " + isBalancedparenthesis(s1));
    System.out.println("s2: " + isBalancedparenthesis(s2));
  }

  private static boolean isBalancedparenthesis(String str) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < str.length(); i++) {
      char x = str.charAt(i);
      if (x == '{' || x == '(' || x == '[') stack.push(x);
      else {
        if (stack.isEmpty()) return false;
        else if (!matching(stack.peek(), x)) {
          return false;
        } else stack.pop();
      }
    }
    return stack.isEmpty();
  }

  private static boolean matching(char a, char b) {
    return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
  }
}
