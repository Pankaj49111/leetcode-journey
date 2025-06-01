class Solution {
    public boolean isHappy(int n) {
        int result=n;
        while(result != 1 && result != 4){
            result = isHappyNo(result);
        }
        if(result==1){
            return true;
        }
        return false;
    }

    public int isHappyNo(int n){
        int sum=0;
        while(n>0){
            int rem = n%10;
            sum += rem*rem;
            n /= 10;
        }
        return sum;
    }
}