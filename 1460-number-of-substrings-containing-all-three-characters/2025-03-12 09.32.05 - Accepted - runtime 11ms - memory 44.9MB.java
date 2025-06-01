class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] arr = {-1, -1, -1};
        int sum = 0;

        for(int i=0; i<n; i++){
            arr[s.charAt(i) - 'a'] = i;

            if(arr[0] != -1 && arr[1] != -1 && arr[2] != -1){
                sum += Math.min(arr[0], Math.min(arr[1], arr[2])) + 1;
            }
        }
        return sum;
    }
}