class Solution {
    public String freqAlphabets(String s) {
        int k=1;
        HashMap<String, Character> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j')
                map.put(String.valueOf(k++), ch);
            else
                map.put(String.valueOf(k++)+"#", ch);
        }
        
        StringBuilder sb = new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i) == '#'){
                String alpha = ""+s.charAt(i-2)+s.charAt(i-1)+"#";
                sb.append(map.get(alpha));
                i-=3;
            }else{
                sb.append(map.get(""+s.charAt(i)));
                i--;
            }
        }
        return sb.reverse().toString();
    }
}