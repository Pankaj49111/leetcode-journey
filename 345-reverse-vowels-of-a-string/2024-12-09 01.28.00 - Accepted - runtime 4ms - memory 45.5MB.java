class Solution {
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        while(i<j){
            while(!vowels.contains(String.valueOf(arr[i])) && i < j) i++;
            while(!vowels.contains(String.valueOf(arr[j])) && i < j) j--;

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;j--;
        }
        return new String(arr);
    }
}