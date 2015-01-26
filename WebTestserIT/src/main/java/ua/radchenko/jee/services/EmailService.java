package ua.radchenko.jee.services;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface EmailService {

	void sendVerificationEmail();

	void sendGeneratedPasswordToEmail();

}
