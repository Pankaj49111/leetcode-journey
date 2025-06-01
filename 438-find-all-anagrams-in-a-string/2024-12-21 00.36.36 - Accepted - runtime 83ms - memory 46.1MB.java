class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()) return list;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for(int i=0; i<p.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0)+1);
        }

        if(sMap.equals(pMap)) list.add(0);

        int j=0, k=p.length();
        while(k < s.length()){
            char ch1 = s.charAt(k++);
            sMap.put(ch1, sMap.getOrDefault(ch1,0)+1);

            char ch2 = s.charAt(j++);
            sMap.put(ch2, sMap.get(ch2)-1);

            if(sMap.get(ch2) == 0){
                sMap.remove(ch2);
            }

            if(sMap.equals(pMap)){
                list.add(j);
            }
        }
        return list;
    }
}