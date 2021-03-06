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

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@Controller
public class UserController {

	/** The sender. */
	@Autowired
	JavaMailSender sender;

	/** The service. */
	@Autowired
	UserService service;

	/**
	 * Login.
	 *
	 * @return Login page
	 */
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	
	/**
	 * Map.
	 *
	 * @param session the session
	 * @return Mapview
	 */
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

	/**
	 * Index.
	 *
	 * @param user the user
	 * @param model the model
	 * @param session the session
	 * @return HomePage
	 */
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

	/**
	 * User.
	 *
	 * @return Signup Page
	 */
	@GetMapping(value = "/user")
	public String user() {
		return "user1";
	}


	/**
	 * Emplist.
	 *
	 * @param user the user
	 * @param model the model
	 * @param session the session
	 * @return Table of All Employee
	 */
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

	/**
	 * List.
	 *
	 * @param user the user
	 * @param model the model
	 * @param session the session
	 * @return return List View of All Employee
	 */
	@GetMapping("allemplist")
	public String list(UserModel user, Model model, HttpSession session) {
		if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
			return "redirect:/login";
		} else {
			model.addAttribute("EmployeeDetails", service.getAllEmployee());
			return "allemplist";

		}
	}

	/**
	 * Edits the.
	 *
	 * @param user the user
	 * @param session the session
	 * @return Edit Profile Page for Logedin User
	 */
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
	
	/**
	 * Profile.
	 *
	 * @param user the user
	 * @param session the session
	 * @return Profile Page of Registered user
	 */
	@GetMapping(value = "/profile")
	String profile(UserModel user, HttpSession session) {
		try {
			if (session.getAttribute("email") == null && session.getAttribute("email").equals("")) {
				return "redirect:/login";
			} else {

				session.setAttribute("EmployeeDetails",
						service.getEmployeeByEmail(((String) session.getAttribute("email"))));

				return "profile";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}
	}


	/**
	 * Logout.
	 *
	 * @param session the session
	 * @return session will be Expired and redirect to the login page
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	/**
	 * Forget.
	 *
	 * @return Forgot password page for Getting Password on Email
	 */
	@GetMapping("/sendmail")
	public String forget() {
		return "sendmail";
	}

	/**
	 * Checkemail.
	 *
	 * @param email the email
	 * @return Check email is existed in database or not
	 */
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

//	@GetMapping(value = "/signup")
//	String signup() {
//		return "signup";
//	}

	/**
 * Save user data.
 *
 * @param user the user
 * @param rd the rd
 * @return  Data from signup page to save into Database
 * @throws IOException Signals that an I/O exception has occurred.
 */
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

	/**
	 * Validate data.
	 *
	 * @param user the user
	 * @param m the m
	 * @param r the r
	 * @param session the session
	 * @return It checks the user is authenticated or not if not return to login
	 */
	@PostMapping("/login")
	public String validateData(UserModel user, Model m, RedirectAttributes r, HttpSession session) {
		String check = service.trytoLogin(user);
		if (check.equals("200")) {

			session.setAttribute("sessionstatus", "true");
			session.setAttribute("email", user.getEmail());
			return "redirect:/";
		} if (check.equals("200")) {
			m.addAttribute("errorforlogin", "Trainee Not Authorized to login");
			return "login";
		}

		else if (check.equals("201")) {
			m.addAttribute("errorforlogin", "Password Not Match");
			return "login";
		}

		else if (check.equals("203")) {
			m.addAttribute("errorforlogin", "Account not actives yet please verify your email");
			return "login";

		}

		else {
			m.addAttribute("errorforlogin", "email not exist ");
			return "login";
		}

	}
	
	/**
	 * Active user account.
	 *
	 * @param id the id
	 * @param key the key
	 * @param r the r
	 * @return activate user to use
	 */
	@GetMapping("activateaccount")
	public String activeUserAccount(@RequestParam Long id, @RequestParam String key, RedirectAttributes r) {
		System.err.println(id+""+key);
		service.activateUserAccount(id, key);
		r.addFlashAttribute("errorforlogin", "account is activated click to login");

		return "redirect:/login";

	}


	/**
	 * Delete grid page.
	 *
	 * @param id the id
	 * @param m the m
	 * @param user the user
	 * @param rd the rd
	 * @param session the session
	 * @return Delete data from Grid View Page
	 */
	@GetMapping("gridview/delete")
	public String deleteGridPage(@RequestParam Long id, Model m, UserModel user, RedirectAttributes rd,
			HttpSession session) {
		service.deleteUser(id);
		return "redirect:/gridview/1";

	}

	/**
	 * Gridedit.
	 *
	 * @param user the user
	 * @param session the session
	 * @param email the email
	 * @return Edit Data of Selected Employee from Grid view page
	 */
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

	/**
	 * Deleteemp.
	 *
	 * @param id the id
	 * @param m the m
	 * @param user the user
	 * @param rd the rd
	 * @return For Delete Employee from Table view
	 */
	@GetMapping("allemp/delete")
	public String deleteemp(@RequestParam Long id, Model m, UserModel user, RedirectAttributes rd) {
		System.out.println(id);
		service.deleteUser(id);
		return "redirect:/allemp";

	}


	/**
	 * Show myprofile.
	 *
	 * @param user the user
	 * @param email the email
	 * @param mod the mod
	 * @return Data from the editprofile page to the database
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@PostMapping("/editprofile")
	public String showMyprofile(UserModel user, String email, Model mod) throws IOException {

		service.updateData(user);
		return "redirect:/profile";
	}

	/**
	 * Grid.
	 *
	 * @param user the user
	 * @param model the model
	 * @param session the session
	 * @param page_id the page id
	 * @return Grid view page with paginated data with 4 data on one page
	 */
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

	/**
	 * Chart.
	 *
	 * @param model the model
	 * @param session the session
	 * @return chart view page
	 */
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

	/**
	 * Send mail.
	 *
	 * @param user the user
	 * @param session the session
	 * @param rd the rd
	 * @param model the model
	 * @return the string
	 */
	/**
	 * @param user
	 * @param session
	 * @param rd
	 * @param model
	 * @return To send Mail Password on Email
	 */
	@PostMapping("/sendmail")
	public String sendMail(UserModel user, HttpSession session, RedirectAttributes rd, Model model) {
		if (service.isUserValid(user).equals("Error")) {

			rd.addFlashAttribute("notfound", "Enter the valid email");
			return "redirect:/sendmail";
		} else {
			session.setAttribute("session", user.getEmail());

			rd.addFlashAttribute("send", " Please Check Your Mail!");
			return "redirect:/login";
		}
	}

	/**
	 * Forgot password.
	 *
	 * @param user the user
	 * @param id the id
	 * @param rd the rd
	 * @return Forgot Password Page
	 */
	@GetMapping("/forgotpassword")
	public String forgotPassword(UserModel user,@RequestParam Long id, RedirectAttributes rd) {
		
		return "forgotPassword";
	}

}
