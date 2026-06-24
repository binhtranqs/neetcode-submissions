class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node cur = head;

        // Bước 1: tạo node mới cho từng node cũ
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        // Bước 2: nối next và random cho node mới
        while (cur != null) {
            Node copyNode = map.get(cur);

            copyNode.next = map.get(cur.next);
            copyNode.random = map.get(cur.random);

            cur = cur.next;
        }

        return map.get(head);
    }
}