package com.ncrash.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ncrash on 2015. 9. 6..
 */
@Service
@Transactional
@Slf4j
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) throws AccountDuplicatedException {
        final Account account = modelMapper.map(dto, Account.class);
        final String username = dto.getUsername();

        if (accountRepository.findByUsername(username) != null) {
            log.error("duplicated username : {}", username);
            throw new AccountDuplicatedException(username);
        }

        // TODO password 암호화 핵심
        Date now = new Date();
        account.setJoined(now);
        account.setUpdated(now);

        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, AccountDto.Update updateDto) {
        final Account account = this.getAccount(id);
        account.setFullName(updateDto.getFullname());
        account.setPassword(updateDto.getPassword());

        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        final Account account = accountRepository.findOne(id);
        if (account == null) {
            throw new AccountNotFoundException(id);
        }

        return account;
    }

}
