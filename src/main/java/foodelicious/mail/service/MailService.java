package foodelicious.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private JavaMailSender mailSender;

	@Autowired
	public MailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void prepareAndSend(String recipient, String title, String message) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("FooDelicious.eeit13702@gmail.com");
			messageHelper.setTo(recipient);
			messageHelper.setSubject(title);
			messageHelper.setText(message);
		};
		try {
			mailSender.send(messagePreparator);
			// System.out.println("sent");
		} catch (MailException e) {
			// System.out.println(e);
			// runtime exception; compiler will not force you to handle it
		}
	}

	public String receiveProblemReports(String sender, String companyName) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(sender);
            messageHelper.setTo("FooDelicious.eeit13702@gmail.com");
            messageHelper.setSubject("廠商問題回報通知");
            messageHelper.setText(companyName + " 回報了一個問題，快去訊息查看!");
	};
	
	try {
        mailSender.send(messagePreparator);
        return "信件發送成功";
    } catch (MailException e) {
        return "信件發送失敗";
    }

  }
	
}
