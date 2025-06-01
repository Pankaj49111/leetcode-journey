class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbsDiff=Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            minAbsDiff = Math.min(minAbsDiff, arr[i]-arr[i-1]);
        }

        List<List<Integer>> response = new ArrayList<>();
        for(int i=1; i<arr.length; i++){
            if(arr[i] - arr[i-1] == minAbsDiff){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                response.add(temp);
            }
        }
        return response;
    }
}