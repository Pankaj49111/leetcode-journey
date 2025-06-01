class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");

        int i=0, j=arr.length-1;
        while(i<j){
            String tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

            i++; j--;
        }
        StringBuilder sb = new StringBuilder();
        for(String word : arr){
            if(!word.isEmpty()){
                if(sb.length() > 0){
                    sb.append(" ");
                }
                sb.append(word);
            }
        }
        return sb.toString();
    }
}