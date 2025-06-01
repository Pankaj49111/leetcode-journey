class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = Arrays.asList(1);
        results.add(result);
        while(result.size() != numRows){
            result=pascal(result);
            results.add(result);
        }
        return results;
    }

    public List<Integer> pascal(List<Integer> result) {
        int arr[] = new int[result.size()+1];
        Arrays.fill(arr,0);
        arr[0]=1; arr[arr.length-1]=1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0){
                arr[i] = result.get(i-1)+result.get(i);
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}