class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        int m = s.length();
        List<Integer> res = new ArrayList<>();
        if(n == m){
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();

            Arrays.sort(sArr); Arrays.sort(pArr);
            if(Arrays.equals(sArr, pArr)){
                res.add(0);
                return res;
            }
        }

        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);

        for(int i=0; i<=m-n; i++){
            if(p.indexOf(s.charAt(i)) != -1){
                char[] sub = s.substring(i, i+n).toCharArray();
                Arrays.sort(sub);

                if(Arrays.equals(pArr, sub)){
                    res.add(i);
                }
            }
        }
        return res;
    }
}