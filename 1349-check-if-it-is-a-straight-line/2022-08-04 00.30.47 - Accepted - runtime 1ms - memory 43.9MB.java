class Solution {
    
    public boolean onLine(int[] p, int[] p1, int[] p2) {
        int x=p[0], x1=p1[0], x2=p2[0], y=p[1], y1=p1[1], y2=p2[1];
        return (y-y1)*(x2-x1) == (x-x1)*(y2-y1);
    }
    
    public boolean checkStraightLine(int[][] cod) {
        if(cod.length == 2) return true;
        for(int i=2; i<cod.length; i++) {
            if(!onLine(cod[i], cod[0], cod[1]))
                return false;
        }
        return true;
    }
}