//package foodelicious.member.validator;
//
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import foodelicious.member.entity.Member;
//
//public class MemberValidator {
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return Member.class.isAssignableFrom(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		Member member = (Member) target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "member.name.empty", "姓名欄不能為空白");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "member.memberId.empty", "帳號欄不能為空白");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "balance", "member.balance.empty", "餘額欄不能為空白");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "member.birthday.empty", "生日欄不能為空白");
//		if (!errors.hasFieldErrors("memberId")) {
//			if (member.getMember_id() != null && member.getMember_id().length() <= 3) {
//				errors.rejectValue("memberId", "member.memberId.length", "帳號欄長度必須大於等於四");
//			}
//		}
//		if (!errors.hasFieldErrors("name")) {
//			if (member.getMember_name() != null && member.getMember_name().length() < 2) {
//				errors.rejectValue("name", "member.name.length", "姓名欄長度必須大於等於二");
//			}
//		}
//	}
//
//
//}
