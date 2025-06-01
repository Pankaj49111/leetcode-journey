class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Set<String> avail = new HashSet<>();
        for(String supply: supplies){
            avail.add(supply);
        }

        Queue<Integer> recipeQueue = new LinkedList<>();
        for(int idx=0; idx<recipes.length; idx++){
            recipeQueue.offer(idx);
        }

        List<String> created = new ArrayList<>();
        int lastSize = -1;

        while(avail.size() > lastSize){
            lastSize = avail.size();
            int qsize = recipeQueue.size();

            while(qsize-- > 0){
                int recIdx = recipeQueue.poll();
                boolean canCreate = true;

                for(String ingr: ingredients.get(recIdx)){
                    if(!avail.contains(ingr)){
                        canCreate = false;
                        break;
                    }
                }

                if(!canCreate){
                    recipeQueue.offer(recIdx);
                } else {
                    avail.add(recipes[recIdx]);
                    created.add(recipes[recIdx]);
                }
            }
        }
        return created;

    }
}