package com.kuchbhibhejo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext ctx;
	
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		ApplicationContextProvider.ctx = arg0;

	}
	
	public static ApplicationContext get(){
		return ctx;
	}

}
