class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1=word1.length(), l2=word2.length();
        StringBuilder sb = new StringBuilder();
        int loop=l2;
        if(l1<l2) loop=l1;
        for(int i=0; i<loop; i++){
            sb.append(""+word1.charAt(i)+word2.charAt(i));
        }
        if(word1.substring(loop).length()>0){
            sb.append(word1.substring(loop));
        } 
        if(word2.substring(loop).length()>0){
            sb.append(word2.substring(loop));
        }
        return sb.toString();
    }
}