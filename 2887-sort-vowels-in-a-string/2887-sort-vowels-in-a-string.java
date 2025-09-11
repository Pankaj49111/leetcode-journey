class Solution {
    public String sortVowels(String s) {
        Queue<Character> cpq = new PriorityQueue<>();
        Queue<Integer> ipq = new PriorityQueue<>();

        String vowels = "aeiouAEIOU";
        for(int i=0; i<s.length(); i++){
            if(vowels.indexOf(s.charAt(i)) != -1){
                cpq.offer(s.charAt(i));
                ipq.add(i);
            }
        }
        List<Character> ls = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            if(!ipq.isEmpty() && i == ipq.peek()){
                ls.add(ipq.poll(), cpq.poll());
            } else {
                ls.add(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : ls) {
            sb.append(c);
        }

        return sb.toString();
    }
}