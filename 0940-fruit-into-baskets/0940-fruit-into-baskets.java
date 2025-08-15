class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=0, j=0, n = fruits.length;
        int max = -1;

        while(j<n){
            // if(map.size() <= 2) {
                if(!map.containsKey(fruits[j])){
                    map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
                    while(map.size() > 2){
                        map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
                        if(map.get(fruits[i]) == 0) map.remove(fruits[i]);
                        i++;
                    }
                    j++;
                    max = Math.max(max, j-i);
                } else {
                    map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
                    j++;
                    max = Math.max(max, j-i);
                }
            // }
        }
        return max;
    }
}