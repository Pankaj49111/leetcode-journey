class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int i=0,j=0;
        List<Integer> result = new ArrayList<>();

        while(j<nums.length-1){
            while(nums[j] != key && j<nums.length-1){
                j++;
            }
            if(nums[j] != key) break;
            System.out.print("j:"+j);
            while(Math.abs(i-j) > k){
                i++;
            }
            while(Math.abs(i-j) <= k && i<nums.length){
                System.out.print(" i:"+i);
                result.add(i);
                i++;
            }
            j++;
            System.out.println();
        }
        if(result.size() == 0) result.add(0);
        return result;
    }
}