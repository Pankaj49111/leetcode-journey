class StockPrice {
    Map<Integer, Integer> timePrice;
    Queue<int[]> max;
    Queue<int[]> min;
    int maxTs;
    public StockPrice() {
        timePrice = new HashMap<>();

        min = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        max = new PriorityQueue<>((a,b) -> (b[0]-a[0]));

        maxTs = 0;
    }
    
    public void update(int ts, int price) {
        timePrice.put(ts, price);

        max.offer(new int[]{price, ts});
        min.offer(new int[]{price, ts});

        maxTs = Math.max(maxTs, ts);
    }
    
    public int current() {
        return timePrice.get(maxTs);
    }
    
    public int maximum() {
        while(true){
            int[] top = max.peek();
            int price = top[0];
            int ts = top[1];

            if(timePrice.get(ts) == price) return price;

            max.poll();
        }
    }
    
    public int minimum() {
        while(true){
            int[] top = min.peek();
            int price = top[0];
            int ts = top[1];

            if(timePrice.get(ts) == price) return price;

            min.poll();
        }
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