package com.ncrash.accounts;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by ncrash on 2015. 9. 5..
 */
public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        Account account = new Account();

        account.setLoginId("ncrash");
        account.setPassword("kdk");

        assertEquals(account.getLoginId(), "ncrash");
    }
}
