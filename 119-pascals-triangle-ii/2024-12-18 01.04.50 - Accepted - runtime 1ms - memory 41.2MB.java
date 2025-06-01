class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<rowIndex+1; i++){
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = (i>0) ? result.get(i-1) : null;

            list.add(1);

            for(int j=1; j<i; j++){
                list.add(prev.get(j-1) + prev.get(j));
            }

            if(i>0) list.add(1);

            result.add(list);
        }

        return result.get(rowIndex);
    }
}