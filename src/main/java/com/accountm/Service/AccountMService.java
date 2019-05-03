package com.accountm.Service;

import com.accountm.model.Accountp;
import com.accountm.model.Transaction;
import com.accountm.model.Userp;

import java.util.List;

/**
 * Created by yaghobabbai on 1/31/2019.
 */
public interface AccountMService {
    public Accountp createAcount(Accountp accountp);
    public Userp createUser(Userp userp);
    public Accountp updateAccount(Accountp accountp);
    public Transaction transfer(Transaction transaction);
    public Transaction trnsaction(Transaction transaction);
    public List<Transaction> bill(Accountp accountp);
}
