class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        else if(n == 2) return "11"; 
        else if(n == 3) return "21"; 
        else if(n == 4) return "1211";
        String s = "1211";

        s = rle(n, 4, s);
        return s;
    }

    String rle(int n, int idx, String s){
        for (int i = idx; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count=1;
            for( int j=1; j<s.length(); j++){
                if(s.charAt(j) == s.charAt(j-1)){
                    count++;
                } else {
                    sb.append(count).append(s.charAt(j-1));
                    count = 1;
                }
            }
            
            sb.append(count).append(s.charAt(s.length()-1));
            s = sb.toString();
        }
        return s;
    }
}