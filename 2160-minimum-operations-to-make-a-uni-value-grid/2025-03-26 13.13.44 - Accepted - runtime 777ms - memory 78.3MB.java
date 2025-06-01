class Solution {
    public int minOperations(int[][] grid, int x) {
        int r = grid.length;
        int c = grid[0].length;
        int[] arr = new int[r*c];
        int idx=0;
        // int[] arr = Arrays.stream(grid).flatMapToInt(Arrays::stream).sorted().toArray();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[idx++] = grid[i][j];
            }
        }
        Arrays.sort(arr);

        int mid = (arr.length)/2;
        int midEle = arr[mid];
        int count=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > midEle) {
                while(arr[i] != midEle && arr[i] >= midEle){
                    arr[i] -= x;
                    count++;
                }
            } else if(arr[i] < midEle) {
                while(arr[i] != midEle && arr[i] <= midEle){
                    arr[i] += x;
                    count++;
                }
            }
            if(arr[i] != midEle) return -1;
        }

        for(int a: arr){
            if(a != midEle) return -1;
        }

        return count;
    }
}