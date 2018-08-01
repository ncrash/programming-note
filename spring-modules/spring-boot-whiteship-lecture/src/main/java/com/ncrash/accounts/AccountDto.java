package com.ncrash.accounts;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Created by ncrash on 2015. 9. 6..
 */
public class AccountDto {
    @Data
    public static class Create {
        @NotEmpty
        @Size(min = 5)
//        @Pattern()
        private String username;

        @NotBlank
        @Size(min = 5)
        private String password;
    }

    @Data
    public static class Response {
        private Long id;
        private String username;
        private String fullname;
        private Date joined;
        private Date updated;
    }

    @Data
    public static class Update {
        private String password;
        private String fullname;
    }
}
