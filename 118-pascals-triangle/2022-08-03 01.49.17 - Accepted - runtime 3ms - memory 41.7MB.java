class Solution {
    
    public List<Integer> getNext(List<Integer> next) {
        int[] arr = new int[next.size() + 1];
        Arrays.fill(arr,0);
        arr[0]=1;arr[arr.length-1]=1;
        
        for(int i=1; i<arr.length-1; i++) {
            if(arr[i]==0) {
                arr[i] = next.get(i)+next.get(i-1);
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> next = Arrays.asList(1);
        result.add(next);
        while(next.size() != numRows) {
            next = getNext(next);
            result.add(next);
        }
        return result;
    }
}