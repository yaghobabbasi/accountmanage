package com.accountm.Service;

import com.accountm.DAO.AccountPRepository;
import com.accountm.DAO.TransactionRepository;
import com.accountm.DAO.UserPRepository;
import com.accountm.model.Accountp;
import com.accountm.model.Transaction;
import com.accountm.model.Userp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by yaghobabbai on 1/31/2019.
 */
@Service
public class AccountMServiceImpl implements AccountMService {

    @Autowired
    AccountPRepository accountPRepository;

    @Autowired
    UserPRepository userPRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public Userp createUser(Userp userp) {
        userp.setCustomernumber(userp.getNationalcode());
        return userPRepository.save(userp);
    }

    public Accountp createAcount(Accountp accountp) {
        Userp userp = userPRepository.findById(accountp.getUserid());
        accountp.setDepositnumber(accountp.getBranchcode() + "-" + userp.getCustomernumber() + "-" + accountp.getAccounttype());
        accountp.setCreatedate(Timestamp.valueOf(LocalDateTime.now()));
        return accountPRepository.save(accountp);
    }

    public Accountp updateAccount(Accountp accountp) {
        Accountp accountp1 = accountPRepository.findFirstByDepositnumber(accountp.getDepositnumber());
        accountp1.setAvailablebalance(accountp.getAvailablebalance());
        accountp1.setBlockamount(accountp.getBlockamount());
        accountp1.setUpdatedate(Timestamp.valueOf(LocalDateTime.now()));
        return accountPRepository.save(accountp1);
    }

    @Transactional
    public Transaction transfer(Transaction transaction) {
        Accountp accountp1 = accountPRepository.findFirstByDepositnumber(transaction.getFromaccount());
        if (accountp1.getAvailablebalance() < transaction.getAmount())
            return null;
        accountp1.setBalance(accountp1.getBalance() - transaction.getAmount());
        accountp1.setAvailablebalance(accountp1.getAvailablebalance() - transaction.getAmount());
        accountp1.setUpdatedate(Timestamp.valueOf(LocalDateTime.now()));
        accountPRepository.save(accountp1);
        Accountp accountp2 = accountPRepository.findFirstByDepositnumber(transaction.getToaccount());
        accountp2.setBalance(accountp2.getBalance() + transaction.getAmount());
        accountp2.setAvailablebalance(accountp2.getAvailablebalance() + transaction.getAmount());
        accountp2.setUpdatedate(Timestamp.valueOf(LocalDateTime.now()));
        accountPRepository.save(accountp2);
        transaction.setCreatedate(Timestamp.valueOf(LocalDateTime.now()));
        transaction.setDescription("انتقال وجه");
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction trnsaction(Transaction transaction) {
        Accountp accountp1 = accountPRepository.findFirstByDepositnumber(transaction.getFromaccount());
        //واریز به حساب
        if (transaction.getTransactiontype() == 1) {
            accountp1.setBalance(accountp1.getBalance() + transaction.getAmount());
            accountp1.setAvailablebalance(accountp1.getAvailablebalance() + transaction.getAmount());
            transaction.setDescription("واریز به حساب");
        }
        //یزداشت از حساب
        else if (transaction.getTransactiontype() == 2) {
            if (accountp1.getAvailablebalance() < transaction.getAmount())
                return null;
            accountp1.setBalance(accountp1.getBalance() - transaction.getAmount());
            accountp1.setAvailablebalance(accountp1.getAvailablebalance() - transaction.getAmount());
            transaction.setDescription("برداشت از حساب");
        }
        accountp1.setUpdatedate(Timestamp.valueOf(LocalDateTime.now()));
        accountPRepository.save(accountp1);
        transaction.setCreatedate(Timestamp.valueOf(LocalDateTime.now()));
       // transaction.setDescription("");
        return transactionRepository.save(transaction);
    }

    public List<Transaction> bill(Accountp accountp) {
        return transactionRepository.findAllByFromaccountOrToaccount(accountp.getDepositnumber(), accountp.getDepositnumber());
    }
}
