package com.accountm.DAO;

import com.accountm.model.Accountp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yaghobabbai on 2/1/2019.
 */
@Repository
public interface AccountPRepository extends CrudRepository<Accountp, Long> {
    Accountp findById(int Id);

    Accountp findAccountpByDepositnumber(String depositNumber);

    Accountp findFirstByDepositnumber(String depositNumber);
}
