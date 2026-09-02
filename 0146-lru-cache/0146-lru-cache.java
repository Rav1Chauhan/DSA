class LRUCache {

    class Node {
        int value;
        int key;
        Node prev;
        Node next;

        Node(int v, int k) {
            value = v;
            key = k;
            prev = null;
            next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int limit = 0;
    int cap = 0;

    public LRUCache(int capacity) {

        head.next = tail;
        tail.prev = head;

        cap = capacity;
    }

    public void put(int key, int value) {

        Node temp = head.next;

        // Check if key already exists
        while (temp != tail) {

            if (temp.key == key) {

                temp.value = value;

                // Move this node to front
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                temp.next = head.next;
                temp.prev = head;

                head.next = temp;
                temp.next.prev = temp;

                return;
            }

            temp = temp.next;
        }

        // If cache is full, remove LRU
        if (limit == cap) {
            deleteNode();
        }

        // Add new node
        addNode(key, value);
    }

    public int get(int key) {

        Node temp = head.next;

        while (temp != tail) {

            if (temp.key == key) {

                // Remove from current position
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                // Move to front
                temp.next = head.next;
                temp.prev = head;

                head.next = temp;
                temp.next.prev = temp;

                return temp.value;
            }

            temp = temp.next;
        }

        return -1;
    }

    public void addNode(int key, int value) {

        Node temp = head.next;

        Node newNode = new Node(value, key);

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;

        limit++;
    }

    public void deleteNode() {

        Node temp = tail.prev;

        temp.prev.next = tail;
        tail.prev = temp.prev;

        limit--;
    }
}