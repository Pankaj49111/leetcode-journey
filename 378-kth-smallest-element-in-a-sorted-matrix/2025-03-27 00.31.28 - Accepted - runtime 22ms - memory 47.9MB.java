class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sorted()
                .boxed().skip(k-1).findFirst().get();
    }
}