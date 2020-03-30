public enum AccountGroups {

    ONE(1);

    AccountGroups(int accountGroup) {
        this.accountGroup = accountGroup;
    }

    private int accountGroup;

    public int getAccountGroup() {
        return accountGroup;
    }
}
