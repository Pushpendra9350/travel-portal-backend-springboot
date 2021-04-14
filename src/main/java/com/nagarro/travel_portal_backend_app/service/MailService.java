package com.nagarro.travel_portal_backend_app.service;

import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.nagarro.travel_portal_backend_app.model.Employee;
import com.nagarro.travel_portal_backend_app.model.GeneratePaaword;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;

	}

	public void sendMailForRegistration(String reciever, Employee employee)
			throws MailException, NoSuchAlgorithmException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(reciever);
		mail.setFrom("travel.portal052020@gmail.com");
		mail.setSubject("Congratulation! Nagarro Travel Portal Information");
		mail.setText(
				"Now! You are a member of Nagarro travel portal family your username and password for the your access to the Nagarro Travel Portal given below:\n\n"
						+ "Username : " + employee.getEmail() + "\nPassword : "
						+ GeneratePaaword
								.toHexString(GeneratePaaword.getSHA(employee.getFirstName() + employee.getEmail()))
						+ "\n\nPlease contact the Travel team if you have any questions." + "\n\nThank you,"
						+ "\nNagarro Travel Team.");
		javaMailSender.send(mail);

	}

	public void sendMailForForgetPassword(String reciever, Employee employee)
			throws MailException, NoSuchAlgorithmException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(reciever);
		mail.setFrom("travel.portal052020@gmail.com");
		mail.setSubject("Nagarro Travel Portal Information");
		mail.setText(
				"You have requested your user name and password for the your access to the Nagarro Travel Portal:\n\n"
						+ "Username : " + employee.getEmail() + "\nPassword : " + employee.getPassward()
						+ "\n\nPlease contact the Travel team if you have any questions." + "\n\nThank you,"
						+ "\nNagarro Travel Team.");
		javaMailSender.send(mail);

	}

}
