package ua.radchenko.jee.forms;

/**
 * @author radchenko.as
 * @version 1.0
 */
public class LoginForm extends AbstractLoginForm {


	private static final long serialVersionUID = 1L;
	private int idRole;

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
}
