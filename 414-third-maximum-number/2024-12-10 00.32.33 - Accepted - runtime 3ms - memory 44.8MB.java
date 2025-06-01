class Solution {
    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE, second=Long.MIN_VALUE, third=Long.MIN_VALUE;

        HashSet<Long> set = new HashSet<>();
        for(int num: nums){
            if(set.add((long)num)){
                if(num>first){
                    third = second;
                    second = first;
                    first = (long)num;
                }else if(num>second){
                    third=second;
                    second=(long)num;
                } else if(num>third){
                    third=(long)num;
                }
            }
        }
        return third == Long.MIN_VALUE ? (int)first : (int)third;
    }
}