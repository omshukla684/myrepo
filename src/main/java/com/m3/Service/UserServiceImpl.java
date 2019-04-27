package com.m3.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.m3.model.UserModel;
import com.m3.dao.UserDao;

/**
 * @author Om narayan shukla
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private JavaMailSender sender;
	@Autowired
	UserDao dao;
	
	@Value("${file.upload-path}")
	private String folderPath;
	
	

	
	
	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#signUp(com.m3.model.UserModel)
	 * Service for Signup and It send Activation link on Email
	 */
	public Map<String, Object> signUp(UserModel user) throws IOException {
		Map<String, Object> response = new HashMap<>();
		if(user.getMultipartimage().isEmpty()) {
			int result=dao.saveUserDataWithoutImg(user);
			
			if (result > 0) {
				response.put("200", "Success");
			} else {
				response.put("204", "Failed");
			}
			Long id = dao.getUserId(user.getEmail());
			Random rand = new Random();

			// Generate random integers in range 0 to 999
			int tokenkey = rand.nextInt(1000);
			dao.saveTokenKey(tokenkey, id);

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			try {
				helper.setTo(user.getEmail());
//		            helper.setText("your password is "+password);
				helper.setText(" click on link to activate account");
				helper.setText("http://localhost:8080/activeaccount?id=" + id + "&key=" + tokenkey);
				helper.setSubject("Mail From Mobiloitte");
				System.err.println("hello");
				sender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
				
			}

			
			return response;
		}
		String fileName = StringUtils.cleanPath(user.getMultipartimage().getOriginalFilename());
		Path path = Paths.get(folderPath + fileName);
		Files.copy(user.getMultipartimage().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		user.setImgUrl(fileName);
		int result= dao.saveUserData(user);
		Long id = dao.getUserId(user.getEmail());
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int tokenkey = rand.nextInt(1000);
		dao.saveTokenKey(tokenkey, id);

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(user.getEmail());
//	            helper.setText("your password is "+password);
			helper.setText(" click on link to activate account");
			helper.setText("http://localhost:8080/activateaccount?id=" + id + "&key=" + tokenkey);
			helper.setSubject("Mail From Mobiloitte");
			System.err.println("hello");
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			
		}

		
		
		if (result > 0) {
			response.put("200", "Success");
		} else {
			response.put("204", "Failed");
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#getAllEmployee()
	 * Get All Employee Details From Database
	 */
	@Override
	public List<Map<String, Object>> getAllEmployee() {
		 return dao.getAllEmployee();
	}
	/* (non-Javadoc)
	 * Activate User From unique Token key
	 * @see com.m3.Service.UserService#activateUserAccount(java.lang.Long, java.lang.String)
	 */
	@Override
	public void activateUserAccount(Long id, String key) {
		dao.activateUserStatus(id, key);
		dao.deleteTokenKey(id, key);		
	}

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#trytoLogin(com.m3.model.UserModel)
	 * User Login Method For Varifying User Details
	 */
	@Override
	public String trytoLogin(UserModel user) 
	{
	try {
		Map<String, Object> userdetail = dao.validateData(user);
		String password = (String) userdetail.get("password");
		int status = (int) userdetail.get("status");
		System.out.println("================="+password);

		if (password.equals(user.getPassword())) {

			if (status != 1) {
				return "203";
			}
			return "200";
		}
		else
		{
			return "201";
		}
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return "202";
}


	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#getEmployeeByEmail(java.lang.String)
	 * Get Employee Details By Email
	 */
	@Override
	public Object getEmployeeByEmail(String email) {

		

		return dao.getEmployeeByEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#deleteUser(java.lang.Long)
	 * Delete User From Database By Particular Id 
	 */
	@Override
	public int deleteUser(Long id) {
		return dao.deleteUser(id);
	}
     /* (non-Javadoc)
     * @see com.m3.Service.UserService#getEmployeesByPage(int, int)
     * Get All Employee By Page 
     */
    @Override
	public List<Map<String, Object>> getEmployeesByPage(int pageid, int total) {
        return dao.getEmployeesByPage(pageid, total);
    }

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#getCount(com.m3.model.UserModel)
	 * Get Count Of User From Database
	 */
	@Override
	public int getCount(UserModel user) {
		return dao.getCount(user);
	}

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#getUserById(java.lang.String)
	 * Get User Details By ID
	 */
	@Override
	public Map<String, Object> getUserById(String id) {
		return dao.getUserById(id);	}

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#updateData(com.m3.model.UserModel)
	 * Update User Data 
	 */
	@Override

	public int updateData(UserModel user) throws IOException {
		if(user.getMultipartimage().isEmpty()) {
			
				return dao.updateData1(user);
			
					
		}else {
	

		 			String fileName = StringUtils.cleanPath(user.getMultipartimage().getOriginalFilename());
		 			Path path = Paths.get(folderPath + fileName);
		 			 Files.copy(user.getMultipartimage().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		 			user.setImgUrl(fileName);
		 			return dao.updateData(user);
		 	
	}	}
	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#getEmailCount(com.m3.model.UserModel)
	 * Get Email count from database
	 */
	@Override
	public String getEmailCount(UserModel user) {
		return dao.getEmailCount(user);
		
	}
	
    /* (non-Javadoc)
     * @see com.m3.Service.UserService#checkemail(java.lang.String)
     * get Email Exist or not in the database
     */
    @Override
    public String checkemail(String email) {
    	return dao.checkemail(email);
    }

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#getAdmin()
	 * Get Count of admin 
	 * 
	 */
	@Override
	public int getAdmin() {
		return dao.getAdmin();
		
	}

	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#getUser()
	 * 
	 * Get User Counts from Database
	 */
	@Override
	public int getUser() {
		return dao.getuser();

	}
	/* (non-Javadoc)
	 * @see com.m3.Service.UserService#isUserValid(com.m3.model.UserModel)
	 * Check User Is Valid Or not for Password Reset
	 */
	@Override
	public String isUserValid(UserModel user) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(user.getEmail());
			helper.setText("Your Password is : " + dao.isValidateUser(user));
			helper.setSubject("Mail From Spring Boot");
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		sender.send(message);
		return "message sent";
	}

}
