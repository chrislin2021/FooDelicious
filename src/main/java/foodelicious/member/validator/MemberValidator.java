package foodelicious.member.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import foodelicious.member.model.Member;


public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberName", "member.memberName.empty", "姓名欄不能為空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberMail", "member.memberMail.empty", "帳號欄不能為空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "member.pwd.empty", "密碼欄不能為空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberBirth", "member.memberBirth.empty", "生日欄不能為空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberPhone", "member.memberPhone.empty", "電話欄不能為空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberAddress", "member.memberAddress.empty", "地址欄不能為空白");
		if (!errors.hasFieldErrors("memberMail")) {
			if (member.getMemberMail() != null && member.getMemberMail().length() <= 3) {
				errors.rejectValue("memberMail", "member.memberMail.length", "帳號欄長度必須大於等於四");
			}
		}
		if (!errors.hasFieldErrors("memberName")) {
			if (member.getMemberName() != null && member.getMemberName().length() < 2) {
				errors.rejectValue("memberName", "member.memberName.length", "姓名欄長度必須大於等於二");
			}
		}
	}


}
