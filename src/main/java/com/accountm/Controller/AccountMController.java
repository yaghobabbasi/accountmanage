package com.accountm.Controller;

import com.accountm.Service.AccountMService;
import com.accountm.model.Accountp;
import com.accountm.model.Transaction;
import com.accountm.model.Userp;
import com.accountm.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yaghobabbai on 1/31/2019.
 */
@RestController
@RequestMapping("/rest")
public class AccountMController {
    @Autowired
    AccountMService accountMService;

    //insert user
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(@RequestBody Userp user) {
        try {
           // return accountMService.createUser(user);
            return Utility.mapToJson(accountMService.createUser(user));
        } catch (Exception ex) {
            return null;
        }
    }

    //create account
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String createAccount(@RequestBody Accountp account) {
        try {
           // return accountMService.createAcount(account);
            return Utility.mapToJson(accountMService.createAcount(account));
        } catch (Exception ex) {
            return null;
        }
    }

    //update account
    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public String updateAccount(@RequestBody Accountp account) {
        try {
           // return accountMService.updateAccount(account);
            return Utility.mapToJson(accountMService.updateAccount(account));
        } catch (Exception ex) {
            return null;
        }
    }

    //transaction
    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public String transaction(@RequestBody Transaction transaction) {
        try {
            //return accountMService.trnsaction(transaction);
            return Utility.mapToJson(accountMService.trnsaction(transaction));
        } catch (Exception ex) {
            return null;
        }
    }

    //transfer
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public String transfer(@RequestBody Transaction transaction) {
        try {
           // return accountMService.transfer(transaction);
            return Utility.mapToJson(accountMService.transfer(transaction));
        } catch (Exception ex) {
            return null;
        }
    }

    //create bill
    @RequestMapping(value = "/bill", method = RequestMethod.GET)
    public String bill(@RequestBody Accountp accountp) {
        try {
            //return accountMService.bill(accountp);
            return Utility.mapToJson(accountMService.bill(accountp));
        } catch (Exception ex) {
            return null;
        }
    }
}
