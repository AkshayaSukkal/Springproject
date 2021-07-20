package com.ecomm.dao;

import com.ecomm.entity.UserDetail;

public interface UserDetailDAO 
{
	public boolean registerUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public UserDetail getUser(String username);
}
