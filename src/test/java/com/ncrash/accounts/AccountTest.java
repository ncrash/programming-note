package com.ncrash.accounts;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

/**
 * Created by ncrash on 2015. 9. 5..
 */
public class AccountTest {

    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testAccount() throws Exception {
        final Account account = new Account();

        account.setUsername("ncrash");
        account.setPassword("kdk");
        assertEquals(account.getUsername(), "ncrash");
    }
}
