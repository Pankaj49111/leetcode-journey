class TopVotedCandidate {
    int[] leaders; int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];

        Map<Integer, Integer> voters = new HashMap<>();
        int leader = -1, maxVotes = 0;

        for(int i=0; i<persons.length; i++){
            int p = persons[i];
            voters.put(p, voters.getOrDefault(p,0)+1);

            if(voters.get(p) >= maxVotes){
                maxVotes = voters.get(p);
                leader = p;
            }
            leaders[i] = leader;
        }
    }
    
    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (times[mid] <= t) l = mid + 1;
            else r = mid - 1;
        }
        return leaders[r];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */