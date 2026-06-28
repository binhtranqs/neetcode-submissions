
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // dummy head và dummy tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // key vừa được dùng, đưa lên đầu
        remove(node);
        addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            // update xong cũng tính là vừa dùng
            remove(node);
            addToHead(node);
        } else {
            Node newNode = new Node(key, value);

            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capacity) {
                // tail.prev là node ít được dùng gần đây nhất
                Node lru = tail.prev;

                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    private void addToHead(Node node) {
        Node first = head.next;

        node.prev = head;
        node.next = first;

        head.next = node;
        first.prev = node;
    }

    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;

        before.next = after;
        after.prev = before;
    }
}