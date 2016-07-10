package com.niit.shopperssite.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopperssite.model.Product;
import com.niit.shopperssite.model.Supplier;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {
@Autowired
private SessionFactory sessionFactory;
@Transactional
public List<Product> list(){
	@SuppressWarnings("unchecked")
	List<Product> listProduct=(List<Product>) sessionFactory.openSession()
	.createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return listProduct;
}
@Transactional
public Product get(String id){
	String hql="select product from where id=" + "'"+ id +"'";
	Query query = sessionFactory.openSession().createQuery(hql);
	@SuppressWarnings("unchecked")
List<Product> listProduct = (List<Product>) query.list();
	
	if (listProduct != null && !listProduct.isEmpty()) {
		return listProduct.get(0);
	}
	
	return null;
	
}
@Transactional
public void saveOrUpdate(Product product){
	sessionFactory.openSession().saveOrUpdate(product);
}
@Transactional
public void delete(String id){
	Product productToDelete=new Product();
    productToDelete.setId(id);
    sessionFactory.openSession().delete(productToDelete);
}
}

