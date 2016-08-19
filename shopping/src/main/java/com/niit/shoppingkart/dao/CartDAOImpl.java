package com.niit.shoppingkart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingkart.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO
{
	@Autowired
	private SessionFactory sessionFactory;


	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession()
				.createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCart;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Transactional
	public void delete(String userId) {
		Cart CartToDelete = new Cart();
		CartToDelete.setUserId(userId);
		sessionFactory.getCurrentSession().delete(CartToDelete);
	}

	@Transactional
	public List<Cart> get(String userId) {
		String hql = "from Cart where userId='"+ userId + "'" + "and status='N'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();
		
		if (listCart != null && !listCart.isEmpty()) {
			return listCart;
		}
		
		return null;
	}

	@Transactional
	public double getTotalAmount(String userId) 
	{
		String hql = "select sum(price) from Cart where userId='"+ userId + "'" + "and status='N'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		double sum = (double)query.uniqueResult();
		return sum;
	}


	

}
