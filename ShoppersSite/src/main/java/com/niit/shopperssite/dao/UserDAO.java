package com.niit.shopperssite.dao;

import java.util.List;

import com.niit.shopperssite.model.User;
import com.niit.shopperssite.model.UserDetails;

public interface UserDAO {
	public List<User> list();
	
	public User get(String id);
	
	public User getByName(String name);
	
	public void saveOrUpdate(User user);
	
	public void saveOrUpdate(UserDetails userDetails);

    public void delete(String id);
    
    public boolean isValidUser(String id, String name, boolean isAdmin);
}
