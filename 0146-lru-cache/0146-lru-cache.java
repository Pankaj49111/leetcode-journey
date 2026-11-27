class LRUCache {
    class Node {
        int key, val;
        Node next, prev;
        Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    Node head, tail;
    int cap;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node != null){
            moveToFront(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            moveToFront(node);
        } else {
            if(map.size() == cap){
                Node rem = tail.prev;
                remove(rem);
                map.remove(rem.key);
            }
            Node node = new Node(key, value);
            addToFront(node);
            map.put(key, node);
        }
    }

    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addToFront(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    void moveToFront(Node node){
        remove(node);
        addToFront(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */