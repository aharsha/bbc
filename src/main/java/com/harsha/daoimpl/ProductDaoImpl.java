package com.harsha.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.harsha.model.Product;



@Component
public class ProductDaoImpl {

	
	@Autowired
	SessionFactory sessionFactory;

	
	
	public void saveProduct(Product product)
	{
		
		Session  session=sessionFactory.openSession();

		session.saveOrUpdate(product);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		
	}
	
public List<Product> retrieveAllProducts()
{
Session session=sessionFactory.openSession();
Query query= session.createQuery("from com.harsha.model.Product");
List<Product> ProductList=query.list();
session.close();
return ProductList;
}
	
public Product getProduct(int ProductId)
{
	Session session=sessionFactory.openSession();
	Product product=session.get(Product.class,ProductId);
	session.close();
	return product;
}
	public void deleteProduct(Product product)
	{
		
		Session session=sessionFactory.openSession();

	session.delete(product);
	
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	}
	
	
}
