package com.harsha.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsha.model.Cart;
import com.harsha.model.Product;

@Component
public class CartDaoImpl {

	@Autowired
	SessionFactory sessionFactory;
	
	public void saveCart(Product product,int quantity)
	{
		Cart cart=new Cart();
		
		cart.setCartId((int)(Math.random()*10000));
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		cart.setProductPrice(product.getProductPrice());
		cart.setProductSupplier(product.getProductSupplier());
		cart.setProductQuantity(quantity);
		cart.setTotalPrice((product.getProductPrice())*(quantity));
		Session session=sessionFactory.openSession();

		session.save(cart);
		
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}
	
	public List<Cart> getAllCartItems()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
	List<Cart>  cartList=query.list();
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	return cartList;
	
	
	}
	
}
