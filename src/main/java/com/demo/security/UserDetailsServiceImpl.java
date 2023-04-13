package com.demo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.member.dao.MemberDao;
import com.demo.member.domain.Member;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private MemberDao memberDao;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetailsServiceImpl loadUserByUsername " + new Date());
		
		Member member = memberDao.findById(username);
        if (member == null) {
            throw new UsernameNotFoundException(String.format("'%s'는 존재하지 않는 사용자입니다.", username));
        }

        return new UserDetailsImpl(member);
	}
	
	

}
