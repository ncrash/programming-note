package com.ncrash.accounts;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Created by ncrash on 2015. 9. 5..
 */
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String loginId;

    private String password;
}
