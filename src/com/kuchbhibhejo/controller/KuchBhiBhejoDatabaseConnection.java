package com.kuchbhibhejo.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kuchbhibhejo.template.KuchBhiBhejoAdminJDBCTemplate;
import com.kuchbhibhejo.util.ApplicationContextProvider;



@Controller
public class KuchBhiBhejoDatabaseConnection {
	
	@RequestMapping("/welcome")
	public ModelAndView testDatabaseConnection() {
		try{
		ApplicationContext ctx = ApplicationContextProvider.get();
		databaseOperations(ctx);
		String message = "Database is connected successfully.";
		return new ModelAndView("welcome", "message", message);
		}catch(Exception e){
			return new ModelAndView("welcome", "message", "Database Connection ERROR !!!! " + e.getMessage());
		}
	}
	
	private void databaseOperations(ApplicationContext context){
		KuchBhiBhejoAdminJDBCTemplate adminJDBCTemplate = 
			      (KuchBhiBhejoAdminJDBCTemplate)context.getBean("adminJDBCTemplate");
		
		System.out.println("------Listing Multiple Records--------" );
        List<KuchBhiBhejoAdmin> admins = adminJDBCTemplate.listAdmins();
        for (KuchBhiBhejoAdmin record : admins) {
           System.out.print("ID : " + record.getId() );
           System.out.print(", Name : " + record.getName() );
           System.out.println(", Password : " + record.getPassword());
        }
	}
}
