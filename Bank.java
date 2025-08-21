class Bank {
    private final long[] bal;

    public Bank(long[] balance) {
        bal = new long[balance.length + 1];
        for (int i = 0; i < balance.length; i++) bal[i + 1] = balance[i];
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) return false;
        if (bal[account1] < money) return false;
        bal[account1] -= money;
        bal[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        bal[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account)) return false;
        if (bal[account] < money) return false;
        bal[account] -= money;
        return true;
    }

    private boolean valid(int account) {
        return 1 <= account && account < bal.length;
    }
}
