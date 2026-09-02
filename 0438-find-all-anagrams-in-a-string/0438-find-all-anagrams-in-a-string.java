class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();

        if(s.length() < p.length()) return res;

        for(int i=0; i<p.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0)+1);
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0)+1);
        }
        if(smap.equals(pmap)) res.add(0);

        int j=0, k=p.length();
        while(k<s.length()){
            char c1 = s.charAt(k++);
            smap.put(c1, smap.getOrDefault(c1, 0)+1);

            char c2 = s.charAt(j++);
            smap.put(c2, smap.get(c2)-1);
            if(smap.get(c2) == 0) smap.remove(c2);

            if(smap.equals(pmap)) res.add(j);
        }
        return res;
    }
}