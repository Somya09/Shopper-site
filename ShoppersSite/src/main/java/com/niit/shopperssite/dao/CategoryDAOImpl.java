package com.niit.shopperssite.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopperssite.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
   @Autowired
   private SessionFactory sessionFactory;
  
   @Transactional
	public List<Category> list() {
		
		List<Category> listCategory = (List<Category>) sessionFactory.openSession()
				.createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCategory;
	}
   @Transactional
   public void saveOrUpdate(Category category){
	   sessionFactory.openSession().saveOrUpdate(category);
   }
   @Transactional
   public void delete(String id){
	   Category deleteCategory=new Category();
	   deleteCategory.setId(id);
	   sessionFactory.openSession().delete(deleteCategory);
	   
   }
   @Transactional
   public Category get(String id){
	   String hql = "from Category where id=" + "'"+ id +"'";
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
   }
@Transactional
public Category getByName(String name){
	 String hql = "from Category where name=" + "'"+ name +"'";
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
}
}

