/*
 * 
 */
package com.m3.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.m3.model.UserModel;

/**
 * The Class UserDaoImpl.
 *
 * @author Om narayan shukla
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#saveUserData(com.m3.model.UserModel)
		 * Query for Save user data on Database
		 */
		@Override
	public int saveUserData(UserModel user) {
		String sql = "insert into table1(firstName,lastName,email,password,confirmPassword,gender,address,salary,role,imgUrl,dob) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, user.getFirstName(),user.getLastName(), user.getEmail(), user.getPassword(), user.getConfirmPassword(),
				user.getGender(),user.getAddress(),user.getSalary(),user.getRole(),user.getImgUrl(),user.getDob());
	}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#saveUserDataWithoutImg(com.m3.model.UserModel)
		 * Query for Save user data in database without Image
		 */
		@Override
		public int saveUserDataWithoutImg(UserModel user) {
			String sql = "insert into table1(firstName,lastName,email,password,confirmPassword,gender,address,salary,role,dob) VALUES(?,?,?,?,?,?,?,?,?,?)";
			return jdbcTemplate.update(sql, user.getFirstName(),user.getLastName(), user.getEmail(), user.getPassword(), user.getConfirmPassword(),
					user.getGender(),user.getAddress(),user.getSalary(),user.getRole(),user.getDob());
		}

		
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#validateData(com.m3.model.UserModel)
		 * Query for All User Details From Database By Email
		 */
		@Override
		public Map<String, Object> validateData(UserModel user) {
			String sql="select * from table1 where email=?";
			return jdbcTemplate.queryForMap(sql,user.getEmail());
		}
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getAllEmployee()
		 *Query for Get All Employee Details From database
		 */
		@Override
		public List<Map<String, Object>> getAllEmployee() {
			  return jdbcTemplate.queryForList("SELECT * FROM table1");
		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#checkEmailAlreadyExist(java.lang.String)
		 * Query for Check Email Exist on Database or Not
		 */
		@Override
		public int checkEmailAlreadyExist(String email) {
			return jdbcTemplate.queryForObject("select count(*) from table1 where email=?",Integer.class,email);
		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getPasswordByEmail(java.lang.String)
		 * Query Password From Database By Email
		 */
		@Override
		public String getPasswordByEmail(String email) {
			return jdbcTemplate.queryForObject("select password from table1 where Email=?",String.class ,email);
		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getEmployeeByEmail(java.lang.String)
		 * Query for Get Employee By Email
		 */
		@Override
		public Map<String, Object> getEmployeeByEmail(String email) {
			return jdbcTemplate.queryForMap("select empId,firstName,lastName,email,password,confirmPassword,gender,address,salary,role,imgUrl,dob from table1 where email=?",email);
		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#deleteUser(java.lang.Long)
		 * Query for Delete User
		 */
		@Override
		public int deleteUser(Long id) {
			String save="delete from table1 where empId=?";
			return jdbcTemplate.update(save,id);

		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getEmployeesByPage(int, int)
		 * Query for Limit Data From database and return all data
		 */
		@Override
		public List<Map<String, Object>> getEmployeesByPage(int pageid, int total) {
			 String sql= "SELECT * FROM table1 LIMIT "+(pageid-1)+","+total+"";
			 
		        return jdbcTemplate.queryForList(sql);		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getCount(com.m3.model.UserModel)
		 * Query for Count of all user data
		 */
		@Override
		public int getCount(UserModel user) {
			String sql = "SELECT count(*) FROM table1";
			 return jdbcTemplate.queryForObject(sql,Integer.class);	             

		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getUserById(java.lang.String)
		 * Query for Get user by id
		 */
		@Override
		public Map<String, Object> getUserById(String id) {
			return jdbcTemplate.queryForMap("select empId,firstName,lastName,email,password,confirmPassword,gender,address,salary,role,imgUrl,dob from table1 where empId=?",id);
		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#updateData(com.m3.model.UserModel)
		 * Query for Update data of User
		 */
		@Override
		public int updateData(UserModel user) {
			String sql="UPDATE table1 SET firstName=?,lastName=?,email=?,password=?,confirmPassword=?,gender=?,address=?,salary=?,role=?,imgUrl=?,dob=? WHERE email=?";
			return jdbcTemplate.update(sql, user.getFirstName(),user.getLastName(), user.getEmail(), user.getPassword(), user.getConfirmPassword(),user.getGender(),user.getAddress(),user.getSalary(),user.getRole(),user.getImgUrl(),user.getDob(),user.getEmail());		}
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#updateData1(com.m3.model.UserModel)
		 * Query for Update data without Image
		 */
		@Override
		public int updateData1(UserModel user) {
			String sql="UPDATE table1 SET firstName=?,lastName=?,email=?,password=?,confirmPassword=?,gender=?,address=?,salary=?,role=?,dob=? WHERE email=?";
			return jdbcTemplate.update(sql, user.getFirstName(),user.getLastName(), user.getEmail(), user.getPassword(), user.getConfirmPassword(),user.getGender(),user.getAddress(),user.getSalary(),user.getRole(),user.getDob(),user.getEmail());		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getEmailCount(com.m3.model.UserModel)
		 * Query for get Email count 
		 */
		@Override
		public String getEmailCount(UserModel user) {
			String sql="select count(*) from table1 where email=?";
			
			return jdbcTemplate.queryForObject(sql,String.class, user.getEmail());
			
		}
		
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getEmailCount(com.m3.model.UserModel)
		 * Query for get Email count 
		 */
		@Override
		public String checkemail(String email) {
                     String sql="select count(*) from table1 where email=?";
			
			return jdbcTemplate.queryForObject(sql,String.class, email);
		}

		
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getAdmin()
		 *  Query for get admin count 
		 *
		 */
		@Override
		public int getAdmin() {
			String str = "select count(*) from table1 where role='Admin'";
			return jdbcTemplate.queryForObject(str, Integer.class);

		}
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getUser(com.m3.model.UserModel)
		 * Query for get User count 
		 */

		@Override
		public int getuser() {
			String str = "select count(*) from table1 where role='user'";
			return jdbcTemplate.queryForObject(str, Integer.class);
		}
		
		
		
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#isValidateUser(com.m3.model.UserModel)
		 * Query for get Password By Email
		 */
		@Override
		public String isValidateUser(UserModel user) {
			String str = "Select password from table1 where email=?";
			return jdbcTemplate.queryForObject(str, String.class, user.getEmail());
		}

		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#saveTokenKey(int, java.lang.Long)
		 * Query for save token in database
		 */
		@Override
		public int saveTokenKey(int tokenkey, Long id) {
	String sql="update table1 SET tokenkey=? where empId=?";
			
			return jdbcTemplate.update(sql,tokenkey,id);		
		}
		
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#getUserId(java.lang.String)
		 * Query for get user id by email
		 */
		@Override
		public Long getUserId(String email) {
			String sql="select empId from table1   where email=?";
			return jdbcTemplate.queryForObject(sql,Long.class,email);
		}
		
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#activateUserStatus(java.lang.Long, java.lang.String)
		 * Query for update activated user to set the status 1
		 */
		@Override
		public int activateUserStatus(Long id, String key) {
			String sql="update table1 SET status='1' where empId=? AND tokenkey=?";
			return jdbcTemplate.update(sql,id,key);
			
		}
		/* (non-Javadoc)
		 * @see com.m3.dao.UserDao#deleteTokenKey(java.lang.Long, java.lang.String)
		 * Query for Delete token after validating user
		 */
		@Override
		public int deleteTokenKey(Long id, String key) {

			String sql="update table1 SET tokenkey=NULL where empId=? AND tokenkey=?";
			return jdbcTemplate.update(sql,id,key);
			
		}
}
