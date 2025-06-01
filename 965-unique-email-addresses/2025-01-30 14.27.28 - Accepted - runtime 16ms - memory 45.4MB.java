class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email : emails){
            String[] emailPart = email.split("@");
            String local = emailPart[0];
            String domain = emailPart[1];

            local = local.split("\\+")[0];
            local = local.replace(".","");
            set.add(local+"@"+domain);
        }
        return set.size();
    }
}