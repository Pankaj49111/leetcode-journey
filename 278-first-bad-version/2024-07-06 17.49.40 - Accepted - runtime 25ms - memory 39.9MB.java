/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0, h = n;
        int pos = 0;
        while(l<=h){
            int mid = l+(h-l)/2;

            if(isBadVersion(mid)){
                pos = mid;
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        return pos;
    }
}