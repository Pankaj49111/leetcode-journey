class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int n: nums){
            List<Integer> ls = new ArrayList<>();
            for(int i=1; i*i<=n; i++) {
                if(n%i == 0){
                    ls.add(i);
                    if(i != n/i) ls.add(n/i);
                }
            }
            // System.out.println(ls);
            if(ls.size() == 4){
                for(int item: ls) sum += item;
            }
        }
        return sum;
    }
}