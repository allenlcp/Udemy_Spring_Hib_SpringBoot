package com.company.springsecurity.demo.dao;

import com.company.springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
