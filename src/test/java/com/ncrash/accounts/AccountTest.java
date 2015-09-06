package com.ncrash.accounts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ncrash on 2015. 9. 5..
 */
public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        Account account = new Account();

        account.setUsername("ncrash");
        account.setPassword("kdk");

        assertEquals(account.getUsername(), "ncrash");
    }
}
