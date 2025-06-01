class Solution {
    public String freqAlphabets(String s) {
        int n=s.length();
        int k=1;
        HashMap<String, Character> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j')
                map.put(String.valueOf(k++), ch);
            else
                map.put(String.valueOf(k++)+"#", ch);
        }
        
        StringBuilder sb = new StringBuilder();
        int i=n-1;
        while(i>=0){
            if(s.charAt(i) == '#'){
                System.out.println(""+s.charAt(i-2)+s.charAt(i-1)+"#");
                
                sb.append(map.get(""+s.charAt(i-2)+s.charAt(i-1)+"#"));
                i-=3;
            }else{
                sb.append(map.get(""+s.charAt(i)));
                i--;
            }
        }
        return sb.reverse().toString();
    }
}