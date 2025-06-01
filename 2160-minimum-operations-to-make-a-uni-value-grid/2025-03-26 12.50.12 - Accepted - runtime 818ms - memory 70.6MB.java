class Solution {
    public int minOperations(int[][] grid, int x) {
        // int r = grid.length;
        // int c = grid[0].length;
        int[] arr = Arrays.stream(grid).flatMapToInt(Arrays::stream).sorted().toArray();

        int mid = (arr.length)/2;
        int midEle = arr[mid];
        int count=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > midEle){
                while(arr[i] != midEle && arr[i] >= midEle){
                    arr[i] -= x;
                    count++;
                }
            } else if(arr[i] < midEle){
                while(arr[i] != midEle && arr[i] <= midEle){
                    arr[i] += x;
                    count++;
                }
            }
        }
        int f = arr[0];
        long c = Arrays.stream(arr).filter(a -> a != f).count();

        for(int a: arr){
            if(a != f) return -1;
        }

        return count;
    }
}