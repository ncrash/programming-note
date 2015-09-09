package com.ncrash.accounts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ncrash on 2015. 9. 5..
 */
public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        final Account account = Account.builder().username("ncrash").password("kdk").build();

        assertEquals(account.getUsername(), "ncrash");
    }
}
