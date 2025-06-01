class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String replacement = word;

            for (String root : dict) {
                if (word.startsWith(root)) {
                    if (root.length() < replacement.length()) {
                        replacement = root;
                    }
                }
            }

            words[i] = replacement;
        }

        return String.join(" ", words);
    }
}