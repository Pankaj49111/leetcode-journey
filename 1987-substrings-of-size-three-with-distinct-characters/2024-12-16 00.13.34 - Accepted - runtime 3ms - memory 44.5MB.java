class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;
        int n=s.length();
        for(int i=0; i<n-2; i++){
            String sub = s.substring(i, i+3);
            Set<Character> set = new HashSet<>();
            boolean flag=true;
            for(char ch: sub.toCharArray()){
                if(!set.add(ch)){
                    flag = false;
                    break;
                }
            }

            if(flag) count++;
        }
        return count;
    }
}