package ua.radchenko.jee.services.impl;

import org.springframework.stereotype.Service;

import ua.radchenko.jee.services.EmailService;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Service("emailService")
public class EmailServiceStub implements EmailService {
	@Override
	public void sendVerificationEmail() {
		// Do nothing
	}

	@Override
	public void sendGeneratedPasswordToEmail() {
		// TODO Auto-generated method stub

	}
}
