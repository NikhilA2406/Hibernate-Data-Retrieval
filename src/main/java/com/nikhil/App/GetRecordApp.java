package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.userinfo;

public class GetRecordApp {

	public static void main(String[] args) 
	{
		SessionFactory sessionfactory = new Configuration().configure().addAnnotatedClass(userinfo.class).buildSessionFactory();
		Session session1=null;
		Session session2=null;
		try
		{
			session1=sessionfactory.openSession();
			session2=sessionfactory.openSession();
			userinfo user=session1.get(userinfo.class, 1);//Eager Loading 
			System.out.println(user);
			userinfo user1=session2.get(userinfo.class, 1);//Eager Loading 
			System.out.println(user1);
//			userinfo user2=session.get(userinfo.class, 2);//Eager Loading 
//			System.out.println(user2);
//			//userinfo user=session.load(userinfo.class, 1);//deprecated//Lazy Loading
//			//userinfo user=session.getReference(userinfo.class, 1);//Lazy Loading
//			if(user!=null)
//			{
//				System.out.println("ID is :"+user.getUid());
//				System.out.println("Name is :"+user.getUname());
//				System.out.println("City is :"+user.getUcity());	
//			}
//			else
//			{
//				System.out.println("There is no Record/Data with given id");
//			}
			
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			
			session1.close();
			session2.close();
			sessionfactory.close();
		}
		
		
	}

}
