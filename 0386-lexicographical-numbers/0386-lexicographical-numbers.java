class Solution {
    // class Trie{
    //     Map<Integer, Trie> child = new HashMap<>();

    // }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ls = new ArrayList<>();
        for(int i=1; i<=n; i++){
            ls.add(i);
        }

        ls.sort((a,b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        return ls;
    }
}