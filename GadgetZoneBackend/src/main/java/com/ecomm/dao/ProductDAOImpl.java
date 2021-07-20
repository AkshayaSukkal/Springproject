package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.entity.Category;
import com.ecomm.entity.Product;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
    @Transactional

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;	
		}catch(Exception e) 
		{
			System.out.println(e);
		return false;
		}
	}
    @Transactional
	@Override
	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
    @Transactional
	@Override
	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;		
		}
		
	}
    @Transactional
	@Override
	public List<Product> getProducts() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> productList=query.list();
		session.close();
		return productList;
	
	}

	@Override
	public Product getProduct(int productId) 
	{

		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
        session.close();
		return product;
	}

}