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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import static java.util.stream.Collectors.toList;

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

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
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

    @ExceptionHandler(UserDuplicatedException.class)
    public ResponseEntity handleUserDuplicatedException(final UserDuplicatedException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("duplicated.username.exception");
        errorResponse.setMessage("[" + e.getUsername() + "] 중복된 유저명 입니다.");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // TODO stream() vs parallelStream()
    // TODO HATEOAS
    // TODO 뷰
    // NSPA 1. JSP, 2. Thymeleaf
    // SPA 3. 앵귤러 4. 리액트

    // Pageable에서 아래 파라미터를 파싱해줌
    // /accounts?page=0&size=20&sort=username,desc&sort=joined,desc
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity getAccounts(Pageable pageable) {
        final Page<Account> page = accountRepository.findAll(pageable);
        final List<AccountDto.Response> content = page.getContent()
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.Response.class))
                .collect(toList());

        final PageImpl<AccountDto.Response> result = new PageImpl<>(content, pageable, page.getTotalElements());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
