class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        String maxS = "", minS = "";

        for(char c: s.toCharArray()){
            if(c != '9'){
                maxS = s.replaceAll(""+c, "9");
                break;
            }
        }
        if(maxS == "") maxS = ""+s;
        for(char c: s.toCharArray()){
            if(c != '0'){
                minS = s.replaceAll(""+c, "0");
                break;
            }
        }
        if(minS == "") minS = ""+s;

        return Integer.parseInt(maxS) - Integer.parseInt(minS);
    }
}