package com.ncrash.accounts;

import lombok.Data;

/**
 * Created by ncrash on 2015. 9. 12..
 */
public class AccountNotFoundException extends RuntimeException {
    private Long id;

    public AccountNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
