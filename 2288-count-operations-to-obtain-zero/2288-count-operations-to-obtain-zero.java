class Solution {
    public int countOperations(int num1, int num2) {
        int count=0;
        while(num1 != 0 && num2 != 0) {
            while(num1 >= num2){
                num1 -= num2;
                count++;
                if(num1 <= 0) return count;
            }

            while(num2 >= num1){
                num2 -= num1;
                count++;
                if(num2 <= 0) return count;
            }
        }
        return count;
    }
}