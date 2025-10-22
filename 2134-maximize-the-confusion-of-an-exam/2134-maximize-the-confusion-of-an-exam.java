class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsec(answerKey, k, 'T'), maxConsec(answerKey, k, 'F'));
    }

    int maxConsec(String ans, int k, char target){
        int left=0, max=0, flip=0;

        for(int rt=0; rt<ans.length(); rt++){
            if(ans.charAt(rt) != target) flip++;

            while(flip > k){
                if(ans.charAt(left) != target) flip--;

                left++;
            }

            max = Math.max(max, rt-left+1);
        }
        return max;
    }
}