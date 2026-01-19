class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int wordCount = j - i;
            StringBuilder line = new StringBuilder();

            // Last line or single word
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalWordLen = 0;
                for (int k = i; k < j; k++) totalWordLen += words[k].length();

                int spaces = maxWidth - totalWordLen;
                int gaps = wordCount - 1;
                int even = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spaceCount = even + (k - i < extra ? 1 : 0);
                        line.append(" ".repeat(spaceCount));
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}