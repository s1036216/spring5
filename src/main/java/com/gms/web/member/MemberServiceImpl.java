package com.gms.web.member ;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.web.command.CommandDTO;
import com.gms.web.mapper.MemberMapper;
import com.gms.web.member.MemberService;
import com.gms.web.util.Separator;
import com.sun.jndi.cosnaming.CNCtx;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper mapper;
	@Autowired MemberDTO member;
	@Autowired CommandDTO cmd;
   
  
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
   
   @Override
   public Map<String,Object> login(CommandDTO cmd) {
      System.out.println("MemberServiceImpl login entered!!!!");
      Map<String,Object> map=new HashMap<>();
      
      String page="";
      String msg="";
      
      member=mapper.login(cmd);
      if (member!=null) {
    	  System.out.println("111111"+member);
          if (cmd.getColumn().equals(member.getPassword())) {
              msg="success";     
        	  page = "auth:common/main.tiles";
              }
          else {
        	  msg="비밀번호가틀립니다";
              page = "public:common/login.tiles";
           
          }
       }
       else {
    	   msg="id가존재하지않습니다";
    	   page = "public:common/join.tiles";
        
       }
      map.put("page", page);
      map.put("msg", msg);
      map.put("user", member);
      return map;
   }
   
   @Override
   public String addMember(MemberDTO mem) {
      
      return String.valueOf(mapper.insertMember(mem));
   }

   @Override
   public String count() {
   /*   return dao.count(cmd);// memberList.length;*/
	   String count=mapper.count();
      return count;
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<?> list(CommandDTO cmd) {
     
    
      return mapper.selectAll(cmd); // ArrayList가 된다
   }

   @Override
   public StudentDTO findById(CommandDTO cmd) {
      
      return mapper.selectById(cmd);
   }

   @Override
   public List<?> findByName(CommandDTO cmd) {
      System.out.println("findByName:: "+cmd.getSearch()+"::");
   /*   return dao.selectByName(cmd);*/
      return mapper.search(cmd);
   }

   @Override
   public String modifiyProfile(MemberDTO bean) {
	   logger.info("서비스에 들어온 이메일주소 {}",bean.getEmail());
	   logger.info("서비스에 들어온 폰 {}",bean.getPhone());
	   logger.info("서비스에 들어온 아이디{}",bean.getId());
	   
    return String.valueOf(mapper.updateProfile(bean));
   }


   @Override
   public String removeUser(CommandDTO cmd) {
      


      // list.get(i)=null;
      // count--;
      return String.valueOf(mapper.deleteUser(cmd));
   }


}