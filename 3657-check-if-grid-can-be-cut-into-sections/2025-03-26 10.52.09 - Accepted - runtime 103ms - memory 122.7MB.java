class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xaxis = new int[rectangles.length][2];
        int[][] yaxis = new int[rectangles.length][2];

        for(int i=0; i<rectangles.length; i++){
            xaxis[i][0] = rectangles[i][0];
            xaxis[i][1] = rectangles[i][2];
            yaxis[i][0] = rectangles[i][1];
            yaxis[i][1] = rectangles[i][3];
        }

        return check(xaxis) || check(yaxis);
    }

    boolean check(int[][] axis){
        Arrays.sort(axis, (a,b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int f = axis[0][1];

        for(int i=0; i<axis.length; i++){
            if(f <= axis[i][0]){
                count++;
                if(count >= 2) return true;
            }
            f = Math.max(f, axis[i][1]);
        }
        return count >= 2;
    }
}