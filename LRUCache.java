import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, DLinkedNode> map;
    private final DLinkedNode head; // pseudo-head
    private final DLinkedNode tail; // pseudo-tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DLinkedNode(0, 0);
        this.tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        DLinkedNode newNode = new DLinkedNode(key, value);
        map.put(key, newNode);
        addAfterHead(newNode);

        if (map.size() > capacity) {
            DLinkedNode lru = popTail();      // least recently used
            map.remove(lru.key);
        }
    }

    /* ===== Doubly linked list helpers ===== */
    private void addAfterHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode p = node.prev;
        DLinkedNode n = node.next;
        p.next = n;
        n.prev = p;
        node.prev = null;
        node.next = null;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addAfterHead(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
