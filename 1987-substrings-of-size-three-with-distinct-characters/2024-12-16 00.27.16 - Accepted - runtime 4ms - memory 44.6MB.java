class Solution {
    public int countGoodSubstrings(String s) {
        int count=0, n=s.length();
        for(int i=0; i<n-2; i++){
            String sub = s.substring(i, i+3);
            Set<Character> set = new HashSet<>();
            // boolean flag=true;
            for(char ch: sub.toCharArray()){
                set.add(ch);
                //     flag = false;
                //     break;
                // }
            }

            if(set.size()==3) count++;
        }
        return count;
    }
}