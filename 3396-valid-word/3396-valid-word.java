class Solution {
    public boolean isValid(String word) {
        boolean vwl = false, cons = false;
        if(word.length() < 3) return false;

        for(char ch: word.toCharArray()){
            if(Character.isLetterOrDigit(ch)){

                if(!vwl){
                    if("aeiouAEIOU".indexOf(ch) != -1){
                        vwl = true;
                    } else {
                        if(Character.isLetter(ch)){
                            cons = true;
                        }
                    }
                }
                if(!cons){
                    if("aeiouAEIOU".indexOf(ch) != -1){
                        vwl = true;
                    } else {
                        if(Character.isLetter(ch)){
                            cons = true;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        if(!vwl) return false;
        if(!cons) return false;
        return true;
    }
}