package org.jsp.library.helper;

import org.jsp.library.dto.Librarian;
import org.jsp.library.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendMailLogic {

	@Autowired
	JavaMailSender mailSender;

	public void librarianSignupMail(Librarian librarian) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		try {
			helper.setFrom("LibraryManagement@gmail.com");
			helper.setSubject("OTP Verification");
			helper.setTo(librarian.getEmail());
			String gender = "";
			if (librarian.getGender().equals("male"))
				gender = "Mr. ";
			else
				gender = "Ms. ";

			String message = "<h1>Hello " + gender + librarian.getName()
					+ ",<br>Your One Time Password for Creating Account with us is,<br>" + librarian.getOtp() + "</h1>";

			helper.setText(message, true);
			
			mailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

    public void studentSignup(Student student) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		try {
			helper.setFrom("LibraryManagement@gmail.com");
			helper.setSubject("Verification Link");
			helper.setTo(student.getEmail());
			String gender = "";
			if (student.getGender().equals("male"))
				gender = "Mr. ";
			else
				gender = "Ms. ";

			String message = "<h1>Hello " + gender + student.getName()
					+ ",<br>Your verification link to Creating Account with us is,<br><a href='https://super-duper-space-bassoon-9r6rjjp464gcpr5r-8080.app.github.dev/students/verify/"+student.getId()+"/"+student.getToken()+"'>Click here</a></h1>";

			helper.setText(message, true);
			
			mailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

    }
}
