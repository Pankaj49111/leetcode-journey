class FoodRatings {
    static class Food {
        String name;
        int rating;
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    Map<String, String> foodToCuisine;
    Map<String, Integer> foodToRating;
    Map<String, PriorityQueue<Food>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new PriorityQueue<>(
                (a, b) -> (a.rating == b.rating) 
                          ? a.name.compareTo(b.name)   // lexicographic tie-break
                          : b.rating - a.rating        // higher rating first
            ));

            cuisineToFoods.get(cuisine).offer(new Food(food, rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        cuisineToFoods.get(cuisine).offer(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineToFoods.get(cuisine);

        while (true) {
            Food top = pq.peek();
            int currentRating = foodToRating.get(top.name);
            if (top.rating == currentRating) {
                return top.name;
            }
            pq.poll(); // remove stale entry
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */