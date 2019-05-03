package com.accountm.DAO;

import com.accountm.model.Userp;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yaghobabbai on 2/1/2019.
 */
public interface UserPRepository extends CrudRepository<Userp, Long> {
    Userp findById(int ID);
}
