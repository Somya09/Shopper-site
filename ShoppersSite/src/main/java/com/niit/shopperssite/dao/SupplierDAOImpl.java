package com.niit.shopperssite.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopperssite.model.Category;
import com.niit.shopperssite.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{
@Autowired
public SessionFactory sessionFactory;
@Transactional
public List<Supplier> list(){
	@SuppressWarnings("unchecked")
	 List<Supplier> listSupplier=(List<Supplier>) sessionFactory.openSession()
			.createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return listSupplier;
}
@Transactional
public Supplier get(String id){
	String hql = "from Supplier where id=" + "'"+ id +"'";
	Query query = sessionFactory.openSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Supplier> listSupplier = (List<Supplier>) query.list();
	
	if (listSupplier != null && !listSupplier.isEmpty()) {
		return listSupplier.get(0);
	}
	
	return null;
}
@Transactional
public Supplier getByName(String name){
	String hql = "from Supplier where name=" + "'"+ name +"'";
	Query query = sessionFactory.openSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Supplier> listSupplier = (List<Supplier>) query.list();
	
	if (listSupplier != null && !listSupplier.isEmpty()) {
		return listSupplier.get(0);
	}

return null;
}
@Transactional
public void saveOrUpdate(Supplier supplier){
	sessionFactory.openSession().saveOrUpdate(supplier);
}
@Transactional
public void delete(String id){
	Supplier deleteSupplier=new Supplier();
	deleteSupplier.setId(id);
	sessionFactory.openSession().delete(deleteSupplier);
}
}