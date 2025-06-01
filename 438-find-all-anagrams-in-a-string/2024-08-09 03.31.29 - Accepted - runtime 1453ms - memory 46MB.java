class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] pC = p.toCharArray();
        Arrays.sort(pC);

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<=s.length() - p.length(); i++){
            String sub = s.substring(i, i+p.length());
            char[] subC = sub.toCharArray();
            Arrays.sort(subC);

            if(Arrays.equals(pC, subC)){
                res.add(i);
            }
        }
        return res;
    }
}