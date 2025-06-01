class Solution {
    public int[] diStringMatch(String s) {
        int i=0, j=s.length();
        int[] arr = new int[j+1];
        int idx=0;
        char[] chars = s.toCharArray();
        for(char ch: chars){
            if(ch == 'I'){
                arr[idx++] = i++;
            } else {
                arr[idx++] = j--;
            }
        }
        arr[idx] = j;
        return arr;
    }
}