class Router {
    private final int size;
    private final Map<Integer, List<Integer>> counts;
    private final Map<PacketKey, int[]> packets;
    private final Queue<PacketKey> queue;

    public Router(final int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public boolean addPacket(final int source, final int destination, final int timestamp) {
        final PacketKey key = new PacketKey(source, destination, timestamp);

        if (packets.containsKey(key))
            return false;

        if (packets.size() >= size)
            forwardPacket();

        packets.put(key, new int[]{source, destination, timestamp});
        queue.offer(key);

        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty())
            return new int[]{};

        final PacketKey key = queue.poll();
        final int[] packet = packets.remove(key);

        if (packet == null)
            return new int[]{};

        final int destination = packet[1];
        final List<Integer> list = counts.get(destination);
        list.remove(0);

        return packet;
    }

    public int getCount(final int destination, final int startTime, final int endTime) {
        final List<Integer> list = counts.get(destination);
        if (list == null || list.isEmpty())
            return 0;

        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);
        return right - left;
    }

    private int lowerBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid) < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    private int upperBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid) <= target) low = mid + 1;
            else high = mid;
        }

        return low;
    }
}

class PacketKey {
    final int source;
    final int destination;
    final int timestamp;

    PacketKey(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacketKey)) return false;
        PacketKey that = (PacketKey) o;
        return source == that.source &&
               destination == that.destination &&
               timestamp == that.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}


/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */