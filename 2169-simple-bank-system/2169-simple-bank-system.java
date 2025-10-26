class Bank {
    Map<Integer, Long> accBal;
    public Bank(long[] balance) {
        accBal = new HashMap<>();

        for(int i=0; i<balance.length; i++){
            accBal.put(i+1, balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!accBal.containsKey(account1) || !accBal.containsKey(account2)) return false;
        long bal = accBal.get(account1);
        if(bal < money) return false;

        accBal.put(account1, bal-money);
        accBal.put(account2, accBal.get(account2)+money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!accBal.containsKey(account)) return false;
        accBal.put(account, accBal.get(account)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!accBal.containsKey(account)) return false;

        long bal = accBal.get(account);
        if(bal < money) return false;
        
        accBal.put(account, bal-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */