package ua.radchenko.jee.forms;

/**
 * @author radchenko.as
 * @version 1.0
 */
public class CreateTestForm implements IForm {
	private static final long serialVersionUID = 1L;
	private String nametest;
	private String description;
	private int time;

	public String getNametest() {
		return nametest;
	}

	public void setNametest(String nametest) {
		this.nametest = nametest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
