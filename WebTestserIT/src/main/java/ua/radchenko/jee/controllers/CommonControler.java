package ua.radchenko.jee.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.radchenko.jee.ApplicationConstants;
import ua.radchenko.jee.entities.Role;
import ua.radchenko.jee.security.CurrentAccount;
import ua.radchenko.jee.security.SecurityUtils;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Controller
public class CommonControler extends AbstractController implements
		InitializingBean {

	private final Map<Integer, String> redirects = new HashMap<Integer, String>();

	@Override
	public void afterPropertiesSet() throws Exception {
		redirects.put(ApplicationConstants.ADMIN_ROLE, "/admin/home");
		redirects.put(ApplicationConstants.ADVANCED_TUTOR_ROLE,
				"/advanced_tutor/home");
		redirects.put(ApplicationConstants.TUTOR_ROLE, "/tutor/home");
		redirects.put(ApplicationConstants.STUDENT_ROLE, "/student/home");
	}

	protected void initRoles(Model model) {
		List<Role> roles = commonService.listAllRoles();
		model.addAttribute("roles", roles);
	}

	@RequestMapping(value = { "/login", "/loginFailed" }, method = RequestMethod.GET)
	public String showLogin(Model model) {
		initRoles(model);
		return "login";
	}

	@RequestMapping(value = { "/myInfo" }, method = RequestMethod.GET)
	public String myInfo(Model model) {
		CurrentAccount currentAccount = SecurityUtils.getCurrentAccount();
		return "redirect:" + redirects.get(currentAccount.getRole());
	}

}
