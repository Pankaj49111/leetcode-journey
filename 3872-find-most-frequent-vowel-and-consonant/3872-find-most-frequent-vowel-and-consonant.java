class Solution {
    public int maxFreqSum(String s) {
        String vowel = "aeiou";

        Map<Character, Integer> vm = new HashMap<>();
        Map<Character, Integer> cm = new HashMap<>();

        int mv=0, mc=0;

        for(char ch: s.toCharArray()){
            if(vowel.indexOf(ch) != -1){
                vm.put(ch, vm.getOrDefault(ch, 0)+1);
                mv = Math.max(mv, vm.get(ch));
            } else {
                cm.put(ch, cm.getOrDefault(ch, 0)+1);
                mc = Math.max(mc, cm.get(ch));
            }
        }
        return (mv+mc);
    }
}