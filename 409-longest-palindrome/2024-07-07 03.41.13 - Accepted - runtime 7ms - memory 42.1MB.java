class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count = 0;
        boolean isOdd = false;
        for(int len: map.values()){
            if(len%2==0){
                count += len;
            } else {
                count += len-1; 
                // to make odd even, will add 1 for as we can handle one odd 
                // if there are more than 1 odd then all of them will become even except one
                // to check for odd adding an odd flag
                isOdd = true;
            }
        }

        return isOdd ? count+1 : count; // +1 to add one odd properly
    }
}