class Solution {
    public boolean isHappy(int n) {
        int res = n;

        while(res != 1 && res != 4){
            res = check(res);
        }

        if(res == 1) return true;

        return false;
    }

    int check(int n){
        int sum = 0;
        while(n != 0){
            int rem = n%10;
            sum += rem*rem; 
            n = n/10;
        }
        return sum;
    }
}