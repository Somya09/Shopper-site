package com.niit.shopperssite.dao;

import java.util.List;

import com.niit.shopperssite.model.Supplier;

public interface SupplierDAO {
public List<Supplier> list();
	
	public Supplier get(String id);
	
	public Supplier getByName(String name);
	
	public void saveOrUpdate(Supplier supplier);
	
	public void delete(String id);
}
