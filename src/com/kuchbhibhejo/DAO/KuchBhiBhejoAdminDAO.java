package com.kuchbhibhejo.DAO;

import java.util.List;

import javax.sql.DataSource;

import com.kuchbhibhejo.controller.KuchBhiBhejoAdmin;


public interface KuchBhiBhejoAdminDAO {

	   /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Student table.
	    */
	   public void create(String name, String userName, String password, String email);
	   /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public KuchBhiBhejoAdmin getAdmin(Integer id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<KuchBhiBhejoAdmin> listAdmins();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void delete(Integer id);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void update(Integer id, String password);

}
