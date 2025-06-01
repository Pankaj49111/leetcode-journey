class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    boolean even;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> b-a);
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            min.offer(num);
            max.offer(min.poll());
        } else {
            max.offer(num);
            min.offer(max.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (max.peek() + min.peek())/2.0;
        } else {
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */