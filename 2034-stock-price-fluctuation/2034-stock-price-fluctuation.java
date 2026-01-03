class StockPrice {

    // timestamp -> price
    private HashMap<Integer, Integer> timePrice;

    // price -> frequency
    private TreeMap<Integer, Integer> priceCount;

    // latest timestamp
    private int maxTimestamp;

    public StockPrice() {
        timePrice = new HashMap<>();
        priceCount = new TreeMap<>();
        maxTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        if (timePrice.containsKey(timestamp)) {
            int oldPrice = timePrice.get(timestamp);
            priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);
            if (priceCount.get(oldPrice) == 0) {
                priceCount.remove(oldPrice);
            }
        }

        // Add new price
        timePrice.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);

        // Update latest timestamp
        maxTimestamp = Math.max(maxTimestamp, timestamp);
    }

    public int current() {
        return timePrice.get(maxTimestamp);
    }

    public int maximum() {
        return priceCount.lastKey();
    }

    public int minimum() {
        return priceCount.firstKey();
    }
}


/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */