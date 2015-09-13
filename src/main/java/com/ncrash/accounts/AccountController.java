package com.ncrash.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;
import javax.xml.ws.EndpointReference;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by ncrash on 2015. 9. 5..
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/accounts", method = POST)
    public ResponseEntity createAccount(@RequestBody @Valid AccountDto.Create account,
                                        BindingResult result) {
        if (result.hasErrors()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode("bad.request");
            errorResponse.setMessage("잘못된 요청입니다.");
            // TODO BindingResult 안에 들어있는 에러 정보 사용하기.

            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }

        /**
         * 서비스 메소드 에러처리
         *
         * 1. 리턴 타입으로 판단
         * 2. 파라미터 이용(서비스 메소드 수행 후 리턴된 파라미터로 확인 가
        */
        final Account newAccount = accountService.createAccount(account);

        final AccountDto.Response response = modelMapper.map(newAccount, AccountDto.Response.class);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ExceptionHandler(AccountDuplicatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAccountDuplicatedException(final AccountDuplicatedException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("duplicated.username.exception");
        errorResponse.setMessage("[" + e.getUsername() + "] 중복된 유저명 입니다.");

        return errorResponse;
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAccountNotFoundException(final AccountNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("[" + e.getId() + "]에 해당하는 계정이 없습니다.");
        errorResponse.setCode("account.not.found.exception");

        return errorResponse;
    }


    // TODO stream() vs parallelStream()
    // TODO HATEOAS
    // TODO 뷰
    // NSPA 1. JSP, 2. Thymeleaf
    // SPA 3. 앵귤러 4. 리액트

    // Pageable에서 아래 파라미터를 파싱해줌
    // /accounts?page=0&size=20&sort=username,desc&sort=joined,desc
    @RequestMapping(value = "/accounts", method = GET)
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<AccountDto.Response> getAccounts(Pageable pageable) {
        final Page<Account> page = accountRepository.findAll(pageable);
        final List<AccountDto.Response> content = page.getContent()
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.Response.class))
                .collect(toList());

        return new PageImpl<>(content, pageable, page.getTotalElements());
    }

    @RequestMapping(value = "/accounts/{id}", method = GET)
    @ResponseStatus(HttpStatus.OK)
    public AccountDto.Response getAccount(@PathVariable Long id) {
        final Account account = accountService.getAccount(id);

        return modelMapper.map(account, AccountDto.Response.class);
    }

    // 일반적인 케이스에서 아래와 같은 방식으로 처리
    // 전체 업데이트: PUT
    // - (username:"ncrash". password:"pass", fullName:null)

    // 부분 업데이트: PATCH
    // - (username:"ncrash")
    // - (password:"pass")
    // - (username:"ncrash", password:"pass")
    @RequestMapping(value = "/accounts/{id}", method = PUT)
    public ResponseEntity updateAccount(@PathVariable Long id,
                                        @RequestBody @Valid AccountDto.Update updateDto,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        final Account updatedAccount = accountService.updateAccount(id, updateDto);

        return new ResponseEntity<>(modelMapper.map(updatedAccount, AccountDto.Response.class), HttpStatus.OK);
    }
}
