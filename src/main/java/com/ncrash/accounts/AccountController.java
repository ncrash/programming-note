package com.ncrash.accounts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ncrash on 2015. 9. 5..
 */
@RestController
public class AccountController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
