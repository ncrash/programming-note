package com.ncrash.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncrash.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ncrash on 2015. 9. 6..
 */
@Transactional
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class AccountControllerTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    AccountService accountService;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilter(springSecurityFilterChain)
                .build();
    }

    private AccountDto.Create accountCreateDto() {
        final AccountDto.Create createDto = new AccountDto.Create();
        createDto.setUsername("daekwon");
        createDto.setPassword("password");
        return createDto;
    }

    @Test
    public void createAccount() throws Exception {
        final AccountDto.Create createDto = accountCreateDto();

        final ResultActions result = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDto)));

        result.andDo(print());
        result.andExpect(status().isCreated());

        //{"id":1,"username":"ncrash","fullname":null,"joined":1441633566578,"updated":1441633566578}
        result.andExpect(jsonPath("$.username", is("daekwon")));

        final ResultActions duplicate = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDto)));

        duplicate.andDo(print());
        duplicate.andExpect(status().isBadRequest());
        duplicate.andExpect(jsonPath("$.code", is("duplicated.username.exception")));
    }

    @Test
    public void createAccount_BadRequest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        AccountDto.Create createDto = new AccountDto.Create();
        createDto.setUsername("   ");
        createDto.setPassword("1234");

        final ResultActions result = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDto)));

        result.andDo(print());
        result.andExpect(status().isBadRequest());
        result.andExpect(jsonPath("$.code", is("bad.request")));
    }

    @Test
    public void getAccounts() throws Exception {
        final AccountDto.Create createDto = accountCreateDto();

        accountService.createAccount(createDto);

        /*
        {
            "content": [
                {
                    "fullname": null,
                    "id": 1,
                    "joined": 1441719422647,
                    "updated": 1441719422647,
                    "username": "ncrash"
                }
            ],
            "first": true,
            "last": true,
            "number": 0,
            "numberOfElements": 1,
            "size": 20,
            "sort": null,
            "totalElements": 1,
            "totalPages": 1
        }
         */
        final ResultActions result = mockMvc.perform(get("/accounts")
				.with(httpBasic(createDto.getUsername(), createDto.getPassword())));

        result.andDo(print());
        result.andExpect(status().isOk());
    }

    @Test
    public void getAccount() throws Exception {
        final AccountDto.Create createDto = accountCreateDto();
        final Account account = accountService.createAccount(createDto);

        final ResultActions result = mockMvc.perform(get("/accounts/" + account.getId())
				.with(httpBasic(createDto.getUsername(), createDto.getPassword())));

        result.andDo(print());
        result.andExpect(status().isOk());
    }

    @Test
    public void updateAccount() throws Exception {
        final AccountDto.Create createDto = accountCreateDto();
        final Account account = accountService.createAccount(createDto);

        final AccountDto.Update updateDto = new AccountDto.Update();
        updateDto.setFullname("daekwon kang");
        updateDto.setPassword("pass");

        final ResultActions result = mockMvc.perform(put("/accounts/" + account.getId())
				.with(httpBasic(createDto.getUsername(), createDto.getPassword()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateDto)));

        result.andDo(print());
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.fullname", is("daekwon kang")));
    }

    @Test
    public void deleteAccount() throws Exception {
        final AccountDto.Create createDto = accountCreateDto();
        final Account account = accountService.createAccount(createDto);

        final ResultActions invalidDeleteRequest = mockMvc.perform(delete("/accounts/12839187241")
            .with(httpBasic(createDto.getUsername(), createDto.getPassword())));

        invalidDeleteRequest.andDo(print());
        invalidDeleteRequest.andExpect(status().isBadRequest());

        final ResultActions validResult = mockMvc.perform(delete("/accounts/" + account.getId())
                .with(httpBasic(createDto.getUsername(), createDto.getPassword())));
        validResult.andDo(print());
        validResult.andExpect(status().isNoContent());
    }
}
