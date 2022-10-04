package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.entity.Users;

@Repository
public class LoginDao {

	@Autowired
	SessionFactory sf;

	public String getpassword(String username) {

		Session session = sf.openSession();
		System.out.println(session);

		System.out.println(username);
		Users user = session.get(Users.class, username);

		if (user == null) {
			return null;
		} else {

			return user.getPassword();
		}
	}
}
