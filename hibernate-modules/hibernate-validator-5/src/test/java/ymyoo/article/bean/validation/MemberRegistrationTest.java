package ymyoo.article.bean.validation;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MemberRegistrationTest {

	/**
	 * The validator to be used for object validation. Will be retrieved once for all test methods.
	 */
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void memberNameIsNull() {
		MemberRegistration memberRegistration = new MemberRegistration(null, "DD@b123", "aasdf@korea.com", "12341234");

		Set<ConstraintViolation<MemberRegistration>> constraintViolations = validator.validate(memberRegistration);

		assertEquals(1, constraintViolations.size());
		assertEquals("이름은 필수 입니다", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void passwordTooShort() {
		MemberRegistration memberRegistration = new MemberRegistration("홍길동", "DD23", "aasdf@korea.com", "12341234");

		Set<ConstraintViolation<MemberRegistration>> constraintViolations = validator.validate(memberRegistration);

		assertEquals(1, constraintViolations.size());
		assertEquals("비밀 번호는 6~20자리로 숫자와 특수 문자가 포함된 영문 대소문자로 입력해 주세요", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void emailIncorrect() {
		MemberRegistration memberRegistration = new MemberRegistration("홍길동", "DD@b123", "aaaa", "12341234");

		Set<ConstraintViolation<MemberRegistration>> constraintViolations = validator.validate(memberRegistration);

		assertEquals(1, constraintViolations.size());
		assertEquals("이메일 형식으로 입력해 주세요", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void phoneNumberTooLong() {
		MemberRegistration memberRegistration = new MemberRegistration("홍길동", "DD@b123", "aasdf@korea.com", "01012345678");

		Set<ConstraintViolation<MemberRegistration>> constraintViolations = validator.validate(memberRegistration);

		assertEquals(1, constraintViolations.size());
		assertEquals("전화 번호는 10자리 이하로 입력해 주세요", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void emailOrPhoneNumberMandatory() {
		MemberRegistration memberRegistration = new MemberRegistration("홍길동", "DD@b123", null, null);

		Set<ConstraintViolation<MemberRegistration>> constraintViolations = validator.validate(memberRegistration);

		assertEquals(1, constraintViolations.size());
		assertEquals("이메일 혹은 전화 번호 둘 중 하나는 필수 입니다", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void memberIsValid() {
		MemberRegistration memberRegistration = new MemberRegistration("홍길동", "DD@b123", "aasdf@korea.com", "012345678");

		Set<ConstraintViolation<MemberRegistration>> constraintViolations = validator.validate(memberRegistration);

		assertEquals(0, constraintViolations.size());
	}
}