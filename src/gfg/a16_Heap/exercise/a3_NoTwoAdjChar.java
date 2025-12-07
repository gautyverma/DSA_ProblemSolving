package gfg.a16_Heap.exercise;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class a3_NoTwoAdjChar {
  public static void main(String[] args) {
    String s = "mississippi";
    String s1 = "aaabc";
    System.out.println(rearrageString(s));
    System.out.println(rearrageString(s1));
  }

  private static String rearrageString(String s) {
    int n = s.length();

    HashMap<Character, Integer> freq = new HashMap<>();
    for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    pq.addAll(freq.entrySet());

    StringBuilder res = new StringBuilder();

    // Work as the previous visited element
    // Initial previous element be '#' and its frequency '-1'
    Map.Entry<Character, Integer> prev = new AbstractMap.SimpleEntry<>('#', -1);

    while (!pq.isEmpty()) {

      Map.Entry<Character, Integer> p = pq.poll();
      res.append(p.getKey());

      if (prev.getValue() > 0) pq.offer(prev);

      prev = new AbstractMap.SimpleEntry<>(p.getKey(), p.getValue() - 1);
    }

    if (res.length() != n) return "";

    // Valid String
    return res.toString();
  }
}
