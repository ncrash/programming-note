package com.ncrash.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by ncrash on 2015. 9. 6..
 */
@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) throws UserDuplicatedException {
        final Account account = modelMapper.map(dto, Account.class);
        final String username = dto.getUsername();

        if (accountRepository.findByUsername(username) != null) {
            throw new UserDuplicatedException(username);
        }

        // TODO password 암호화 핵심
        Date now = new Date();
        account.setJoined(now);
        account.setUpdated(now);

        return accountRepository.save(account);
    }
}
