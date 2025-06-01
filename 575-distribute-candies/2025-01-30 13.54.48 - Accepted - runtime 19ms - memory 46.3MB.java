class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for(int type: candyType){
            set.add(type);
            if(set.size()>candyType.length/2) return candyType.length/2;
        }

        return set.size();
    }
}