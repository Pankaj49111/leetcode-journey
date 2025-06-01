class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int allowed = candyType.length/2;

        for(int type: candyType){
            set.add(type);
        }

        if(set.size() >= allowed){
            return allowed;
        } else {
            return set.size();
        }
    }
}