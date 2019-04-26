package com.m3.controller;


import java.io.IOException;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.m3.Service.UserService;
import com.m3.model.UserModel;
import com.sun.mail.iap.Response;

@Controller
public class UserController {

	@Autowired
	JavaMailSender sender;

	@Autowired
	UserService service;

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping(value = "/map")
	public String map(HttpSession session) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {

				session.setAttribute("EmployeeDetails",
						service.getEmployeeByEmail(((String) session.getAttribute("email"))));

				return "map";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@GetMapping(value = "/")
	public String index(UserModel user, Model model, HttpSession session) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {
				model.addAttribute("admincount", service.getAdmin());
				model.addAttribute("usercount", service.getUser());
				return "dashboard";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}

	}

	@GetMapping(value = "/user")
	public String user() {
		return "user1";
	}

//	
//	@GetMapping("gridview")
//	public String grid(UserModel user, Model mod) {
//			mod.addAttribute("EmployeeDetails",service.getAllEmployee());
//			return "gridview";
	// }
	@GetMapping("/allemp")
	public String emplist(UserModel user, Model model, HttpSession session) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {

				model.addAttribute("EmployeeDetails", service.getAllEmployee());
				return "allemp";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@GetMapping("allemplist")
	public String list(UserModel user, Model model, HttpSession session) {
		if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
			return "redirect:/login";
		} else {
			model.addAttribute("EmployeeDetails", service.getAllEmployee());
			return "allemplist";

		}
	}

	@GetMapping(value = "/editprofile")
	String edit(UserModel user, HttpSession session) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {

				session.setAttribute("EmployeeDetails",
						service.getEmployeeByEmail(((String) session.getAttribute("email"))));

				return "editprofile";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/sendmail")
	public String forget() {
		return "sendmail";
	}

	@GetMapping(value = "/checkemail")
	@ResponseBody
	public String checkemail(@RequestParam String email) {

		Integer emaildashid = Integer.parseInt(service.checkemail(email));

		if (emaildashid <= 0) {
			return "201";
		} else {
			
			return "200";
		}
	}

	@GetMapping(value = "/signup")
	String signup() {
		return "signup";
	}

	@PostMapping("savedata")
	public String saveUserData(UserModel user, RedirectAttributes rd) throws IOException {

		Integer emaildashid = Integer.parseInt(service.getEmailCount(user));
		if (emaildashid <= 0) {
			
			
			
			service.signUp(user);
			return "login";
		} else {

			rd.addFlashAttribute("error", "Email Allready Exist");
			return "redirect:/user";
		}
		// http://localhost:8080/gridview

	}

	@PostMapping("/login")
	public String validateData(UserModel user, Model m, RedirectAttributes r, HttpSession session) {
		String check = service.trytoLogin(user);
		if (check.equals("200")) {

			session.setAttribute("sessionstatus", "true");
			session.setAttribute("email", user.getEmail());
			return "redirect:/";
		} else if (check.equals("201")) {
			m.addAttribute("errorforlogin", "invalid password");
			return "login";
		} else {
			m.addAttribute("errorforlogin", "email not exist");
			return "login";
		}
	}
//	@PostMapping("login-validate")
//	public String loginValidation(UserModel user, Model model) {
//		
//		System.out.println(user);
//		int response = service.loginValidate(user);
//		// E-mail-Validation
//		if (response == 404) {
//			model.addAttribute("errorMessage", "Email not found.");
//			return "Login";
//		}
//		// Password-Validation
//
//		else if (response == 201) {
//			model.addAttribute("errorMessage", "Invalid Password");
//			return "Login";
//		}
//		// E-mail & Password Validationhttp://localhost:8080/gridview
//
//		else
//			model.addAttribute("userEmail", user.getEmail());
//		model.addAttribute("EmployeeDetails", service.getEmployeeByEmail(user.getEmail()));
//
//		return "gridview";
//
//	}

	@GetMapping("gridview/delete")
	public String deleteGridPage(@RequestParam Long id, Model m, UserModel user, RedirectAttributes rd,
			HttpSession session) {
		service.deleteUser(id);
		return "redirect:/gridview/1";

	}

	@GetMapping(value = "grid/editprofile")
	String gridedit(UserModel user, HttpSession session, @RequestParam String email) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {

				session.setAttribute("EmployeeDetails", service.getEmployeeByEmail(email));

				return "editprofile";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@GetMapping("allemp/delete")
	public String deleteemp(@RequestParam Long id, Model m, UserModel user, RedirectAttributes rd) {
		System.out.println(id);
		service.deleteUser(id);
		return "redirect:/allemp";

	}

//	
//	@GetMapping("/user")
//	public String editPage(Model mod,UserModel user,String id) {
//		mod.addAttribute("EmployeeDetails",service.getUserById(id));
//		
//		return "user1";
//	}
	@PostMapping("/editprofile")
	public String showMyprofile(UserModel user, String email, Model mod) throws IOException {

		service.updateData(user);
		return "redirect:/editprofile";
	}

	@GetMapping("/gridview/{page_id}")
	public String grid(UserModel user, Model model, HttpSession session, @PathVariable int page_id) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {
				int total = 4;
				if (page_id == 1) {

				} else {
					page_id = (page_id - 1) * total + 1;
				}
				int totalCount = service.getCount(user);
				int pageNumber = totalCount / total;
				if (totalCount % total != 0) {
					pageNumber++;
				}
				model.addAttribute("pageNumber", pageNumber);
				model.addAttribute("EmployeeDetails", service.getAllEmployee());
				model.addAttribute("EmployeeDetails", service.getEmployeesByPage(page_id, total));
				return "gridview";
			}
		} catch (Exception e) {
			System.err.println(e);
			return "redirect:/login";
		}

	}

	@GetMapping("/chart-view")
	public String chart(Model model, HttpSession session) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {
				model.addAttribute("admincount", service.getAdmin());
				model.addAttribute("usercount", service.getUser());
				return "chartview";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}
	}



	

}
