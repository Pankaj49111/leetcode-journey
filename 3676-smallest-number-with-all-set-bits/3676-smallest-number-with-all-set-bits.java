class Solution {
    public int smallestNumber(int n) {
        while(inValid(n)) n++;

        return n;
    }

    boolean inValid(int n){
        String bits = Integer.toBinaryString(n);
        return bits.chars().filter(a -> a != '1').findAny().isPresent();
    }
}