package com.harsha.daoimpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsha.dao.CategoryDao;
import com.harsha.model.Category;

@Component
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean testSessionFactory() {
		System.out.println("---------"+sessionFactory);
		return true;
	}
	
	public void saveCategory(Category category)
	{
		if(category.getCategoryId()==0)
		{
		int id=(int)(Math.random()*10000);
		category.setCategoryId(id);
		System.out.println("no id in object");
		}
		Session  session=sessionFactory.openSession();

		session.saveOrUpdate(category);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		
	}
	
public List<Category> retrieveAllCategory()
{
Session session=sessionFactory.openSession();
Query query= session.createQuery("from com.harsha.model.Category");
List<Category> categoryList=query.list();
/*
for(Category cat: categoryList)
{
	Category category=cat;
	System.out.println(category.getCategoryId());
	System.out.println(category.getCategoryDiscription());
	System.out.println(category.getCategoryName());
}
*/
session.close();
return categoryList;
}
	
public Category getCategory(int categoryId)
{
	Session session=sessionFactory.openSession();
	Category category=session.get(Category.class,categoryId);
	System.out.println(category);
	System.out.println(category.getCategoryDiscription());
	session.close();
	return category;
}
	public void deleteCategory(Category category)
	{
		
		Session session=sessionFactory.openSession();

	session.delete(category);
	
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	}
	
	
	

}
