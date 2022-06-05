package LRU;

import java.util.HashMap;
import java.util.Map;

class Node {

  int value;
  int key;
  Node pre;
  Node next;
}

class LRUCache {

  int capacity;
  Node head;
  Node tail;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.pre = head;
    map = new HashMap<>();
  }

  void removeFromList(Node node) {
    Node pre = node.pre;
    Node next = node.next;
    pre.next = next;
    next.pre = pre;

  }

  void moveToHead(Node node) {
    Node first = head.next;
    head.next = node;
    node.pre = head;
    first.pre = node;
    node.next = first;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      removeFromList(node);
      moveToHead(node);
      return node.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    Node node;
    if (map.containsKey(key)) {
      node = map.get(key);
      node.value = value;
      removeFromList(node);
      moveToHead(node);
    } else {
      node = new Node();
      node.value = value;
      node.key = key;
      map.put(key, node);
      moveToHead(node);
      if (map.size() > capacity) {
        Node toRemove = tail.pre;
        removeFromList(toRemove);
        map.remove(toRemove.key);
      }
    }
  }
}

