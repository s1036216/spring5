package com.gms.web.member ;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   
  
   
   
   @Override
   public Map<String,Object> login(CommandDTO cmd) {
      System.out.println("MemberServiceImpl login entered!!!!");
      Map<String,Object> map=new HashMap<>();
      
      String page;
      member=mapper.login(cmd);
      if (member!=null) {
    	  System.out.println("111111"+member);
          if (cmd.getColumn().equals(member.getPass())) {
                   page = "auth:common/main.tiles";
              }
          else {
              page = "public:common/login.tiles";
           
          }
       }
       else {
           page = "public:common/login.tiles";
        
       }
      map.put("page", page);
      return map;
   }
   
   @Override
   public String addMember(Map<String, Object> map) {
      System.out.println("Member serviceImpl entered");
      String result="";
      MemberDTO m = (MemberDTO) map.get("member");
      System.out.println("넘어온 학생 회원정보 ==="+ m.toString());
   /*   @SuppressWarnings("unchecked")
      List<MajorDTO> list= (List<MajorDTO>) map.get("major");
      System.out.println("넘어온 과목들 !!!"+list.toString());
      result= dao.insertMember(map);
      Separator.cmd.setDir("home");
      Separator.cmd.setPage("main");
      Separator.cmd.process();*/
      return result;
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
      /*list=(List<StudentDTO>) dao.selectAll(cmd);*/
    
      return null; // ArrayList가 된다
   }

   @Override
   public StudentDTO findById(CommandDTO cmd) {
      StudentDTO stu = new StudentDTO();
      /*stu = dao.selectById(cmd);*/
      return stu;
   }

   @Override
   public List<?> findByName(CommandDTO cmd) {
      System.out.println("findByName:: "+cmd.getSearch()+"::");
   /*   return dao.selectByName(cmd);*/
      return null;
   }

   @Override
   public String modifiyProfile(MemberDTO bean) {
      String result = "";
      // findById(bean.getPw()).setPw(bean.getPw());
      CommandDTO cmd=new CommandDTO();
      cmd.setSearch(bean.getId());
      /*MemberDTO mem =dao.login(cmd);
      if (!bean.getName().equals("")) {
         mem.setName(bean.getName());
      }
      if (!bean.getPw().equals("")) {
         mem.setPw(bean.getPw());
      }
      if (!bean.getSsn().equals("")) {
         mem.setSsn(bean.getSsn());
      }
      System.out.println("serviceImpl*****" + mem);
*/      return result;
   }


   @Override
   public String removeUser(CommandDTO cmd) {
      String removeResult = "";


      // list.get(i)=null;
      // count--;
      return removeResult;
   }


}