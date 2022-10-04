package com.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.LoginDao;
import com.entity.User;

@Service
public class LoginService {

	@Autowired
	LoginDao dao;
	
public boolean validate(User user) {
	
	String dbpass=dao.getpassword(user.getUsername());
	
if(dbpass.equals(user.getPassword())) {
	return true;
}
else {

	return false;
}
} 
}
