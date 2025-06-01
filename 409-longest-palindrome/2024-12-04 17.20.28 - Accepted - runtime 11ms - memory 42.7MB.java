class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Long> map = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                
        int count=0;
        boolean isOdd = false;

        for(long len: map.values()){
            if(len % 2 != 0) {
                count += len-1; isOdd = true;
            }
            else count += len;
        }
        return isOdd ? count + 1 : count; 
    }
}