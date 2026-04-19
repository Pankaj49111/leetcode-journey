class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> freq = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++){
            freq.computeIfAbsent(groupSizes[i], k->new ArrayList()).add(i);
        }
        // System.out.println(freq);
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> e: freq.entrySet()){
            if(e.getKey() == e.getValue().size()){
                res.add(e.getValue());
            } else {
                int k=e.getKey();
                List<Integer> ls = e.getValue();
                for (int i = 0; i < ls.size(); i += k) {
                    res.add(ls.subList(i, i + k));
                }
            }
        }
        // System.out.println(res);
        return res;
    }
}