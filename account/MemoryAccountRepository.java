package main.account;

import java.util.*;

public class MemoryAccountRepository implements AccountRepository{
    private static MemoryAccountRepository accountRepository = new MemoryAccountRepository();

    private MemoryAccountRepository() {}

    public static MemoryAccountRepository getInstance() {
        return accountRepository;
    }

    private static List<Account> store = new ArrayList<>();

    @Override
    public void save(Account account) {
        store.add(account);
    }

}
