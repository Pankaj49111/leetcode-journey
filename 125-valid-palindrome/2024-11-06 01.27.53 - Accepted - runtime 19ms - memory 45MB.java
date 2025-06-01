class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        
        // int i=0, j=s.length()-1;
        // while(i<=j){
        //     char f = s.charAt(i); 
        //     char e = s.charAt(j);
        //     if(!Character.isLetterOrDigit(f)){
        //         i++;
        //     } else if(!Character.isLetterOrDigit(e)){
        //         j--;
        //     } else {
        //         if(Character.toLowerCase(f) != Character.toLowerCase(e)) return false;
        //         i++; j--;
        //     }
        // }
        // return true;

        String finalStr = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return IntStream.range(0, finalStr.length()/2)
                    .allMatch(i -> finalStr.charAt(i) == finalStr.charAt(finalStr.length()-i-1));
    }
}