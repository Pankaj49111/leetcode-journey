class Solution {
    public int maxDiff(int num) {
        String str = String.valueOf(num);

        char maxRep = ' ';
        for(char c: str.toCharArray()){
            if(c != '9'){
                maxRep = c;
                break;
            }
        }
        String maxStr = (maxRep == ' ') ? str : str.replace(maxRep, '9');

        char minRep = ' ';
        char toRepWith = ' ';

        if(str.charAt(0) != '1'){
            minRep = str.charAt(0);
            toRepWith = '1';
        } else {
            for(int i=1; i<str.length(); i++){
                char c = str.charAt(i);
                if(c != '0' && c != '1'){
                    minRep = c;
                    toRepWith = '0';
                    break;
                }
            }
        }

        String minStr = (minRep == ' ') ? str : str.replace(minRep, toRepWith);

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}