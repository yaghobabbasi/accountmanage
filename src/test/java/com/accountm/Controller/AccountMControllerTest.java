package com.accountm.Controller;

import com.accountm.model.Accountp;
import com.accountm.model.Transaction;
import com.accountm.model.Userp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by yaghobabbai on 2/10/2019.
 */
public class AccountMControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    // @Test
    public void createUser() throws Exception {
        String uri = "/rest/user";
        Userp userp = new Userp();
        // userp.setId(2);
        userp.setFathername("12");
        userp.setPhonenumber("12");
        userp.setNationalcode("12");
        userp.setMobilenumber("12");
        userp.setAddress("12");
        userp.setBirthdate("12");
        userp.setLastname("12");
        userp.setFirstname("12");
        userp.setCustomernumber("1212");

        String inputJson = super.mapToJson(userp);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.print("status code" + status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("result:" + content);
        // assertEquals(content, "User is created successfully");
    }

    // @Test
    public void createAccount() throws Exception {
        String uri = "/rest/account";
        Accountp accountp = new Accountp();
        accountp.setBalance(1000L);
        //  accountp.setAccountnumber("10");
        accountp.setAccounttype("01");
        accountp.setAvailablebalance(1000);
        accountp.setBlockamount(0);
        accountp.setBranchcode("123");
        accountp.setCurrency(1);
        accountp.setDepositstatus(1);
        accountp.setDescription("ایجاد حساب جاری");
        accountp.setUserid(3);

        String inputJson = super.mapToJson(accountp);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.print("status account code" + status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("account result:" + content);
    }

   // @Test
    public void updateAccount() throws Exception {
        String uri = "/rest/account";
        Accountp accountp = new Accountp();
        accountp.setBalance(1000L);
        accountp.setAvailablebalance(900);
        accountp.setBlockamount(100);
        accountp.setDescription("آپدیت حساب جاری");
        accountp.setDepositnumber("23424234");
        String inputJson = super.mapToJson(accountp);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andReturn();
         int status = mvcResult.getResponse().getStatus();
        System.out.print("status account code" + status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("account result:" + content);
    }

    //@Test
    public void transaction() throws Exception {
        String uri = "/rest/transfer";
        Transaction transaction = new Transaction();
        transaction.setDescription("transfer");
        transaction.setAmount(200L);
        transaction.setFromaccount("23424234");
        transaction.setToaccount("123456789");
        transaction.setTransactiontype(2);
        //transaction.setCreatedate(Timestamp.valueOf(LocalDateTime.now()));

        String inputJson = super.mapToJson(transaction);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.print("status transfer code" + status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("transfer result:" + content);
    }

  //  @Test
    public void transfer() throws Exception {
        String uri = "/rest/transaction";
        Transaction transaction = new Transaction();
        transaction.setDescription("transaction");
        transaction.setAmount(200L);
        transaction.setFromaccount("23424234");
        transaction.setTransactiontype(2);

        String inputJson = super.mapToJson(transaction);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.print("status transaction code" + status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("trnsaction result:" + content);
    }

    @Test
    public void bill() throws Exception {
        String uri = "/rest/bill";
        Accountp accountp = new Accountp();
        accountp.setDepositnumber("23424234");

        String inputJson = super.mapToJson(accountp);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.print("status bill code" + status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("bill result:" + content);
    }
}