package com.accountm.DAO;

import com.accountm.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaghobabbai on 2/1/2019.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByFromaccountOrToaccount(String fromAccount, String toAccount);
}
