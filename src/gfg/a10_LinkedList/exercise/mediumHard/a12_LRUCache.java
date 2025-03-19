package gfg.a10_LinkedList.exercise.mediumHard;

import java.util.HashMap;
import java.util.Map;

public class a12_LRUCache {
  class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private final Map<Integer, Node> cache;
  private final Node head, tail;

  public a12_LRUCache(int cap) {
    this.capacity = cap;
    this.cache = new HashMap<>();

    // Dummy head and tail
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    // head will always -1 and start after head over cache starts and tail.prev value updated
    // accordingly
    head.next = tail;
    tail.prev = head;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void insertToFront(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    Node node = cache.get(key);
    remove(node);
    insertToFront(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      node.value = value;
      remove(node);
      insertToFront(node);
    } else {
      if (cache.size() == capacity) {
        // Remove least recently used (LRU) node
        Node lru = tail.prev;
        remove(lru);
        cache.remove(lru.key);
      }
      Node newNode = new Node(key, value);
      insertToFront(newNode);
      cache.put(key, newNode);
    }
  }
}

/*
--- Dry Run use case
* Operations:
LRUCache cache = new LRUCache(3);
cache.put(1, 10);  // [1] -> 10
cache.put(2, 20);  // [2, 1]
cache.put(3, 30);  // [3, 2, 1]
cache.put(4, 40);  // [4, 3, 2] (Evicts 1)
cache.get(2);      // [2, 4, 3] (Moves 2 to front)
cache.put(5, 50);  // [5, 2, 4] (Evicts 3)
Step-by-Step Execution
Step	Operation	Cache (Most Recently Used → Least Recently Used)	Notes
1	put(1, 10)	[1]	Add (1,10)
2	put(2, 20)	[2, 1]	Add (2,20)
3	put(3, 30)	[3, 2, 1]	Add (3,30)
4	put(4, 40)	[4, 3, 2]	Add (4,40), Evict (1,10)
5	get(2)	[2, 4, 3]	Move 2 to front
6	put(5, 50)	[5, 2, 4]	Add (5,50), Evict (3,30)

* */
