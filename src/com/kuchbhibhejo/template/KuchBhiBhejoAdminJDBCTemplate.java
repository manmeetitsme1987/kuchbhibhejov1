package com.kuchbhibhejo.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kuchbhibhejo.DAO.KuchBhiBhejoAdminDAO;
import com.kuchbhibhejo.controller.KuchBhiBhejoAdmin;
import com.kuchbhibhejo.mapper.KuchBhiBhejoAdminMapper;

public class KuchBhiBhejoAdminJDBCTemplate implements KuchBhiBhejoAdminDAO{

	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	   public void create(String name, String userName, String password, String email) {
	      String SQL = "insert into Admin (Name, UserName, Password, Email) values (?, ?, ?, ?)";
	      
	      jdbcTemplateObject.update( SQL, name, userName, password, email);
	      System.out.println("Created Record Name = " + name + " Password = " + userName);
	      return;
	   }

	   public KuchBhiBhejoAdmin getAdmin(Integer id) {
	      String SQL = "select * from Admin where Admin_Id = ?";
	      KuchBhiBhejoAdmin admin = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{id}, new KuchBhiBhejoAdminMapper());
	      return admin;
	   }

	   public List<KuchBhiBhejoAdmin> listAdmins() {
	      String SQL = "select * from Admin";
	      List <KuchBhiBhejoAdmin> admins = jdbcTemplateObject.query(SQL, 
	                                new KuchBhiBhejoAdminMapper());
	      return admins;
	   }

	   public void delete(Integer id){
	      String SQL = "delete from admin where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }

	   public void update(Integer id, String password){
	      String SQL = "update Admin set password = ? where Admin_id = ?";
	      jdbcTemplateObject.update(SQL, password, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	   }

}
