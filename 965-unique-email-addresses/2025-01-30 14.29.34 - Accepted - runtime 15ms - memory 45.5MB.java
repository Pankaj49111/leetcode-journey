class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email : emails){
            String[] emailPart = email.split("@");
            
            set.add(emailPart[0].split("\\+")[0].replace(".","")+"@"+emailPart[1]);
        }
        return set.size();
    }
}