class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        
        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1; j<n-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int k=j+1, l=n-1;

                while(k<l){
                    long total = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];

                    if(total == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;

                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    } else if(total < target){
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return list;
    }
}