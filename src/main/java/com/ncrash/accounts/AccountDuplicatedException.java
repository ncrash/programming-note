package com.ncrash.accounts;

import lombok.Data;

/**
 * Created by ncrash on 2015. 9. 7..
 *
 * 토스 4장 예외처리 참고해서 코드정리
 */
@Data
public class AccountDuplicatedException extends RuntimeException {
    private String username;

    public AccountDuplicatedException(String username) {
        this.username = username;
    }
}
