class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        int count = 0;
        if(a+b > c && b+c > a && a+c > b) {
            if(a==b) count++;
            if(b==c) count++;
            if(a==c) count++;

            if(count == 0) return "scalene";
            else if(count < 3) return "isosceles";
            else return "equilateral";
        }
        return "none";
    }
}