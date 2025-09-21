// self-implemented doubly-linked list + Hashmap solution, O(1)

package repo.Hash.lc146;
import java.util.HashMap;


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Solution146 {
    public static class LRUCache {

        class Node {
            int key;
            int value;
            Node prev = null;
            Node next = null;
            Node (int key, int value) {
                this.key = key;
                this.value = value;
            }
            Node (int key, int value, Node prev, Node next) {
                this.key = key;
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }
        class DoublyLinkedList {
            Node head;
            Node tail;
            DoublyLinkedList() {
                this.head = null;
                this.tail = null;
            }
            void addLast(Node node) {
                if (head == null && tail == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = tail.next;
                }
            }
            Node removeFirst() {
                if (head == null) {
                    return null;
                } else if (head.next == null) {
                    Node elem = head;
                    head = null;
                    tail = null;
                    return elem;
                } else {
                    Node elem = head;
                    head.next.prev = null;
                    head = head.next;
                    elem.next = null;
                    return elem;
                }
            }

            void remove(Node node) {
                if (node.prev != null && node.next != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node.next = null;
                    node.prev = null;
                } else if (node.prev == null && node.next != null) {
                    Node elem = head;
                    head.next.prev = null;
                    head = head.next;
                    elem.next = null;
                } else if (node.prev != null && node.next == null) {
                    Node elem = tail;
                    tail.prev.next = null;
                    tail = tail.prev;
                    elem.prev = null;
                } else {
                    head = null;
                    tail = null;
                }
            }

        }
        HashMap<Integer, Node> hash;
        DoublyLinkedList li;
        int capacity;
        int curr_usage;

        public LRUCache(int capacity) {
            this.hash = new HashMap<>();
            this.li = new DoublyLinkedList();
            this.capacity = capacity;
            this.curr_usage = 0;
        }

        public int get(int key) {
            if (!hash.containsKey(key)) {
                return -1;
            } else {
                Node nodeGet = hash.get(key);
                li.remove(nodeGet);
                li.addLast(nodeGet);
                return nodeGet.value;
            }
        }

        public void put(int key, int value) {
            if (hash.containsKey(key)) {
                Node oldNode = hash.get(key);
                oldNode.value = value;
                li.remove(oldNode);
                li.addLast(oldNode);
            } else {
                if (curr_usage == capacity) {
                    Node removedNode = li.removeFirst();
                    hash.remove(removedNode.key);
                } else {
                    curr_usage++;
                }
                Node newNode = new Node(key, value);
                hash.put(key, newNode);
                li.addLast(newNode);
            }
        }
    }

}
