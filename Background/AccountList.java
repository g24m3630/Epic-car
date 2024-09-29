import java.util.LinkedList;
import java.util.List;

public class AccountList {
    private LinkedList<Account> account;

    public AccountList() {
        account = new LinkedList<>();
    }

    public void add(Account acc) {
        account.add(acc);
    }

    public void remove(Account acc) {
        account.remove(acc);
    }

    public int getNumAccounts() {
        return account.size();
    }

    public Account getAccount(int k) {
        if (k >= 0 && k < account.size()) {
            return account.get(k);
        }
        return null;
    }
        public Account getAccount(String accNumber) {
        for (Account acc : account) {
            if (acc.getAccNumber().equalsIgnoreCase(accNumber)) {
                return acc;
            }
        }
        return null;
    }

    public List<Account> getAccountsForName(String customer) {
        List<Account> account = new LinkedList<>();
        for (Account acc: account) {
            if (acc.getAccHolder().equalsIgnoreCase(customer)){
                account.add(acc);
            }
        }
        return account;
    }
}
