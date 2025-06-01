class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int i=0, sum = 0;

        for(int j=0; j<s.length(); j++){
            arr[s.charAt(j) - 'a']++;

            while(hasAllChars(arr)){
                sum += s.length() - j;
                arr[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return sum;
    }
    boolean hasAllChars(int[] arr){
        if(arr[0] > 0 && arr[1] > 0 && arr[2] > 0) return true;

        return false;
    }
}