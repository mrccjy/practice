package com.practice.leetcode.editor.cn;
  
//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表

import java.util.HashMap;

public class LruCache{
  public static void main(String[] args) {
      LruCache solution = new LruCache();
      LRUCache lru = solution.new LRUCache(1);
      lru.put(1,1);
      lru.put(2,2);
      System.out.println(lru.get(1));
      lru.put(3,3);
      System.out.println(lru.get(2));
      lru.put(4,4);
      System.out.println(lru.get(1));
      System.out.println(lru.get(3));
      System.out.println(lru.get(4));

  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class LRUCache {
      HashMap<Integer, Node> map;
      int size;
      Node head;
      Node tail;
      int capacity;
      public LRUCache(int capacity) {
          this.capacity = capacity;
          map = new HashMap(5000);
      }

      public int get(int key) {
          Node n = map.get(key);
          if (n != null) {
              adjust(n);
              return n.val;
          }
          return -1;
      }

      private void adjust(Node n) {
          if (n == head) {
              return;
          }
          Node tmp = n.prev;
          if (tmp != null) {
              n.prev.next = n.next;
              if (n.next != null) {
                  n.next.prev = n.prev;
              }
              n.next = head;
              head.prev = n;
              n.prev = null;
              head = n;
              if (n == tail) {
                  tail = tmp;
              }
          }
      }

      public void put(int key, int value) {

          Node n = map.get(key);
          if (n != null) {
              n.val = value;
              adjust(n);
          } else {
              if (size == capacity) {
                  Node tmp = tail.prev;
                  map.remove(tail.key);
                  tail.prev = null;
                  if (tmp != null) {
                      tmp.next = null;

                  }
                  tail = tmp;
                  if (tail == null) {
                      head = tail;
                  }

              }
              n = new Node();
              n.key = key;
              n.val = value;
              n.next = head;
              if (head != null) {
                  head.prev = n;
              }
              head = n;
              if (this.tail == null) {
                  this.tail = this.head;
              }
              if (size < capacity) {
                  size++;
              }
              map.put(key, n);
          }
      }


      class Node {
          Node prev;
          Node next;
          int key;
          int val;

      }
  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//leetcode submit region end(Prohibit modification and deletion)

}