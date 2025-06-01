class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            n = check(n);
            if(n == 1) return true;
        }

        return false;
    }

    int check(int n){
        int sum = 0;
        while(n > 0){
            int rem = n%10;
            sum += rem*rem; 
            n = n/10;
        }
        return sum;
    }
}