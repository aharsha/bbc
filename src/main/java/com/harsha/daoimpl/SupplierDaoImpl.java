package com.harsha.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsha.model.Category;
import com.harsha.model.Supplier;

@Component
public class SupplierDaoImpl {

	
	@Autowired
	SessionFactory sessionFactory;

	
	
	public void saveSupplier(Supplier supplier)
	{
		if(supplier.getSupplierId()==0)
		{
		int id=(int)(Math.random()*10000);
		supplier.setSupplierId(id);
		System.out.println("supplier adding");
		}
		Session  session=sessionFactory.openSession();

		session.saveOrUpdate(supplier);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		
	}
	
public List<Supplier> retrieveAllSuppliers()
{
Session session=sessionFactory.openSession();
Query query= session.createQuery("from com.harsha.model.Supplier");
List<Supplier> supplierList=query.list();
session.close();
return supplierList;
}
	
public Supplier getSupplier(int supplierId)
{
	Session session=sessionFactory.openSession();
	Supplier supplier=session.get(Supplier.class,supplierId);
	session.close();
	return supplier;
}
	public void deleteSupplier(Supplier supplier)
	{
		
		Session session=sessionFactory.openSession();

	session.delete(supplier);
	
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	}
	
	
	
}
