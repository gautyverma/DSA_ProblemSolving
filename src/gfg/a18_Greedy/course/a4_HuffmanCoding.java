package gfg.a18_Greedy.course;

import java.util.PriorityQueue;

public class a4_HuffmanCoding {

  static class Node {
    char ch;
    int freq;
    Node left, right;

    public Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    char chars[] = {'a', 'd', 'e', 'f'};
    int freqs[] = {30, 40, 80, 60};
    huffmanCodes(chars, freqs);
  }

  private static void huffmanCodes(char[] chars, int[] freqs) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

    // Step - 1 - insert all leaf nodes into pq
    for (int i = 0; i < chars.length; i++) {
      pq.offer(new Node(chars[i], freqs[i], null, null));
    }
    // Step 2 - build huffman tree
    while (pq.size() > 1) {
      Node left = pq.poll(), right = pq.poll();
      pq.add(new Node('$', left.freq + right.freq, left, right));
    }
    // Step - 3 - printCodes
    printCodes(pq.poll(), " ");
  }

  private static void printCodes(Node root, String code) {
    if (root == null) return;
    if (root.ch != '$') {
      System.out.println(root.ch + " " + code);
    }
    printCodes(root.left, code + "0");
    printCodes(root.right, code + "1");
  }
}
