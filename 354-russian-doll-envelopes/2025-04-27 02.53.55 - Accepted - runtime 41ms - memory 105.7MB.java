class Solution {
    public int maxEnvelopes(int[][] env) {
        int n = env.length;
        Arrays.sort(env, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] heights = new int[n];
        for(int i=0; i<n; i++){
            heights[i] = env[i][1];
        }

        int[] ls = new int[n];
        int len = 0;

        for(int ht: heights){
            int idx = binarySearch(ls, 0, len-1, ht);
            ls[idx] = ht;
            if(idx == len) len++; 
        }

        return len;
    }

    int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}