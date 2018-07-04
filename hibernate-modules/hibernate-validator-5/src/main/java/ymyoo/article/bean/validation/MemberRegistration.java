package ymyoo.article.bean.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Pattern;

/**
 * fork from : https://www.popit.kr/javabean-validation%EA%B3%BC-hibernate-validator-%EA%B7%B8%EB%A6%AC%EA%B3%A0-spring-boot/
 */
//TODO 메시지를 message.properties 파일로 코드베이스로 정의. 테스트케이스에서도 message.properties로 검증
@Getter
@Setter
@AllArgsConstructor
@ScriptAssert(lang = "javascript",
        script = "(_.email != null && _.email.length() > 0) || (_.phoneNumber != null && _.phoneNumber.length() > 0)",
        alias = "_", message = "이메일 혹은 전화 번호 둘 중 하나는 필수 입니다")
public class MemberRegistration {

    @NotEmpty(message = "이름은 필수 입니다")
    private String name;

    @NotEmpty(message = "비밀 번호는 필수 입니다")
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "비밀 번호는 6~20자리로 숫자와 특수 문자가 포함된 영문 대소문자로 입력해 주세요")
    private String password;

    @Email(message = "이메일 형식으로 입력해 주세요")
    private String email;

    @Length(min = 1, max = 10, message = "전화 번호는 10자리 이하로 입력해 주세요")
    private String phoneNumber;
}