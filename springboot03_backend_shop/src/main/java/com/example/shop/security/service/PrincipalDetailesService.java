package com.example.shop.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.shop.members.dao.MembersDAO;
import com.example.shop.members.dto.MembersDTO;

@Service
public class PrincipalDetailesService implements UserDetailsService{
	
	@Autowired
	private MembersDAO membersDAO;

	public PrincipalDetailesService() {
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
		System.out.println("localUserByUsername:" + memberEmail);
		
		MembersDTO userEntity = membersDAO.selectByEmail(memberEmail);
//		System.out.println("useEntity:" + userEntity.getMemberName());
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(memberEmail);
		}
		return new PrincipalDetails(userEntity);
	}
}
