package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.dao.UserJPADao;
import com.example.security.model.User;

//provides service
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserJPADao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);
		
		if(user==null)
			throw new
		UsernameNotFoundException
		("User not found");
		
		// TODO Auto-generated method stub
		return new UserDetailsImpl(user);
	}
	

}
