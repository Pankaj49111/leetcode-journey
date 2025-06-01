class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        /*
        00 01 02
        10 11 12
        20 21 22

        00 01 02 12 22 21 20 10 11
        i->0 j->0..2 -> (n-1)
        j->2 i->0..2 -> (n-1)
        i->2 j->2..0
        j->0 i->1
        i,j->1
        */

        int top=0, left=0;
        int bot=matrix.length-1, right=matrix[0].length-1;

        while(top <= bot && left <= right){
            for(int i=left; i<=right; i++){
                list.add(matrix[top][i]);
            }
            top += 1;

            for(int i=top; i<=bot; i++){
                list.add(matrix[i][right]);
            }
            right -= 1;
            if (top <= bot) {
                for(int i=right; i>=left; i--){
                    list.add(matrix[bot][i]);
                }
                bot -= 1;
            }

            if (left <= right) {
                for(int i=bot; i>=top; i--){
                    list.add(matrix[i][left]);
                }
                left += 1;
            }
        }
        return list;
    }
}