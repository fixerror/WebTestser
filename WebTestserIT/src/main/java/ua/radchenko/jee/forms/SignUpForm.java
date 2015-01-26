package ua.radchenko.jee.forms;

/**
 * @author radchenko.as
 * @version 1.0
 */
public class SignUpForm extends AbstractLoginForm implements IForm {

	private static final long serialVersionUID = 1L;

	private String password2;

	private String email;

	private String name;

	public Boolean getActive() {
		return active;
	}

	private Boolean active;

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
