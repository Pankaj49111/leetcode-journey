class Solution {
    public int reverse(int x) {
        int res = 0;
        boolean neg = x<0; 
        String rev = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
        try{
            res = Integer.parseInt(rev);
        } catch(Exception e){
            return 0;
        }
        return neg ? -res : res;
    }
}