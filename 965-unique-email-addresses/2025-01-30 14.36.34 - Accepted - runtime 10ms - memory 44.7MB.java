class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueSet = new HashSet<>();

        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            String[] emailPart = email.split("@");
            for(char ch: emailPart[0].toCharArray()){
                if(ch == '.') continue;
                if(ch == '+') break;

                sb.append(ch);
            }
            sb.append('@');
            sb.append(emailPart[1]);
            uniqueSet.add(sb.toString());
        }
        return uniqueSet.size();
    }
}