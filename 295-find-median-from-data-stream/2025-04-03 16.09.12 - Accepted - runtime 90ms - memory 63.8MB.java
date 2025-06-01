class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        max.offer(num);

        if(!min.isEmpty() && max.peek() > min.peek()){
            min.offer(max.poll());
        }

        if(max.size() > min.size()+1){
            min.offer(max.poll());
        } else if(min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
            // If max has more elements, the median is its root
            return max.peek();
        } else {
            // If both heaps have the same size, the median is the average of the two roots
            return (max.peek() + min.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */