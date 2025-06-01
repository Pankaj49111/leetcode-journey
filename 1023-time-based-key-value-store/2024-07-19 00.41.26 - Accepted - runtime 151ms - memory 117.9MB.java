class TimeMap {
    Pair pair;
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Pair(value, timestamp));
        } else {
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(value, timestamp));
            map.put(key, arr);
        }
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(map.containsKey(key)){
            List<Pair> ls = map.get(key);
            int low=0, high=ls.size()-1;

            while(low <= high){
                int mid = low + (high-low)/2;
                int timeVal = ls.get(mid).timestamp;
                if(timeVal == timestamp){
                    return ls.get(mid).value;
                } if(timeVal <= timestamp){
                    res = ls.get(low).value;
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return res;
    }

    class Pair{
        String value;
        int timestamp;
        public Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */