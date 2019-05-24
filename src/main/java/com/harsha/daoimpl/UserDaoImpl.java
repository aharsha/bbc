package com.harsha.daoimpl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsha.model.User;

@Component
public class UserDaoImpl {

	@Autowired
SessionFactory sessionFactory;
	
	
	
	public void addUser(User user)
	{
	Session session=sessionFactory.openSession();	
user.setRole("ROLE_USER");
user.setEnabled(true);
	session.save(user);

Transaction transaction=session.beginTransaction();

transaction.commit();
session.close();
	}
	
	
	public boolean checkLogin(User user)
	{
		Session  session =sessionFactory.openSession();
	Query  query=session.createQuery("from User where email=:em and password=:pw");
query.setParameter("em",user.getEmail());
query.setParameter("pw",user.getPassword());

Object  object=query.uniqueResult();
User  user2=(User)object;

if(user2==null)
{
	return false;
}

else
{
	return  true;
}

	}
}
