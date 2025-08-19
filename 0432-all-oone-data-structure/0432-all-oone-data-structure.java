class AllOne {
    Map<String, Integer> map;
    Map<Integer, Bucket> countBucket;

    // Doubly linked list of Buckets
    private Bucket head;
    private Bucket tail;

    public AllOne() {
        map = new HashMap<>();
        countBucket = new HashMap<>();

        // dummy head and tail
        head = new Bucket(0);
        tail = new Bucket(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        int count = map.getOrDefault(key, 0);
        map.put(key, count + 1);

        Bucket currBucket = countBucket.get(count);
        Bucket newBucket = countBucket.get(count + 1);

        if (newBucket == null) {
            newBucket = new Bucket(count + 1);
            countBucket.put(count + 1, newBucket);
            insertAfter(currBucket == null ? head : currBucket, newBucket);
        }

        newBucket.keys.add(key);

        if (currBucket != null) {
            currBucket.keys.remove(key);
            if (currBucket.keys.isEmpty()) {
                removeBucket(currBucket);
                countBucket.remove(count);
            }
        }
    }
    
    public void dec(String key) {
        if (!map.containsKey(key)) return;

        int count = map.get(key);
        Bucket currBucket = countBucket.get(count);

        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
            Bucket newBucket = countBucket.get(count - 1);
            if (newBucket == null) {
                newBucket = new Bucket(count - 1);
                countBucket.put(count - 1, newBucket);
                insertBefore(currBucket, newBucket);
            }
            newBucket.keys.add(key);
        }

        currBucket.keys.remove(key);
        if (currBucket.keys.isEmpty()) {
            removeBucket(currBucket);
            countBucket.remove(count);
        }
    }
    
    public String getMaxKey() {
        return tail.prev != head ? tail.prev.keys.iterator().next() : "";
    }
    
    public String getMinKey() {
        return head.next != tail ? head.next.keys.iterator().next() : "";
    }

    private class Bucket {
        int count;
        Set<String> keys;
        Bucket prev, next;

        Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private void insertAfter(Bucket prev, Bucket newBucket) {
        newBucket.prev = prev;
        newBucket.next = prev.next;
        prev.next.prev = newBucket;
        prev.next = newBucket;
    }

    private void insertBefore(Bucket next, Bucket newBucket) {
        insertAfter(next.prev, newBucket);
    }

    private void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */