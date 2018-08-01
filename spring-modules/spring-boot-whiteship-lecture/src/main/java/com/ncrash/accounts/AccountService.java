package com.ncrash.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) throws AccountDuplicatedException {
        final Account account = modelMapper.map(dto, Account.class);
        final String username = dto.getUsername();

        if (accountRepository.findByUsername(username) != null) {
            log.error("duplicated username : {}", username);
            throw new AccountDuplicatedException(username);
        }

        account.setPassword(passwordEncoder.encode(account.getPassword()));

        Date now = new Date();
        account.setJoined(now);
        account.setUpdated(now);

        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, AccountDto.Update updateDto) {
        final Account account = this.getAccount(id);
        account.setFullName(updateDto.getFullname());
        account.setPassword(passwordEncoder.encode(account.getPassword()));

        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        final Optional<Account> account = accountRepository.findById(id);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(id);
        }

        return account.get();
    }

    public void deleteAccount(Long id) {
        accountRepository.delete(getAccount(id));
    }
}
