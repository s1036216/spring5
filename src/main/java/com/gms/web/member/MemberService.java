package com.gms.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gms.web.command.CommandDTO;

@Component
public interface MemberService {
	
	public int addMember(Map<?,?> map);
	public Map<String, Object> login(CommandDTO cmd); /*client를 */
	public List<?> list(CommandDTO cmd);
	public String count();
	public StudentDTO findById(CommandDTO cmd);
	public List<?> findByName(CommandDTO cmd);
	public String modifiyProfile(MemberDTO bean);
	public String removeUser(CommandDTO cmd);
	
}
