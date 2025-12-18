class Solution {
    int[] parent;
    public boolean equationsPossible(String[] eq) {
        parent = new int[26];

        for(int i=0; i<26; i++) parent[i] = i;

        for(String e: eq){
            if(e.charAt(1) == '='){
                union(e.charAt(0)-'a', e.charAt(3)-'a');
            }
        }

        for(String e: eq){
            if(e.charAt(1) == '!'){
                if(find(e.charAt(0)-'a') == find(e.charAt(3)-'a')) return false;
            }
        }
        return true;
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        parent[find(y)] = find(x);
    }
}