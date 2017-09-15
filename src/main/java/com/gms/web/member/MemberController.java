package com.gms.web.member;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.gms.web.command.CommandDTO;
import com.gms.web.complex.PathFactory;
import com.gms.web.grade.MajorDTO;
import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParameterList;

import sun.print.resources.serviceui;

@Controller
@SessionAttributes("list")
@RequestMapping({"/member","/student"})
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired MemberService service; //싱글톤
	@Autowired CommandDTO cmd;
	@Autowired PageProxy pxy;
	@Autowired MemberDTO member;
	@Autowired MajorDTO major; 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String memberAdd(@ModelAttribute MemberDTO member,
			@RequestParam("subject") List<String> list) {
		System.out.println("진입123123123");
		logger.info("등록 id {}",member.getId());
		logger.info("등록 이름 {}",member.getName());
		logger.info("등록 비번 {}",member.getPassword());
		logger.info("등록 과목 {}",list );  
		MajorDTO mj =null;
	Map<String,Object> paramMap= new HashMap<>();
		 paramMap.put("member", member);
		 List<MajorDTO> parmList=new ArrayList<>();
		/* int random = (int) (Math.random()*9999)+1000;*/
		 for(String m:list) {
			 mj = new MajorDTO();
			   /*mj.setMajorId(String.valueOf(random));*/
			 
			 mj.setId(member.getId());
			 mj.setSubjId(m);
			  mj.setTitle(m);
				parmList.add(mj);		
		 }
		 	
		paramMap.put("list",parmList);
		service.addMember(paramMap);
	
		return "redirect:/member/list/1";
	}
	
	@RequestMapping("/list/{pno}")
	@SuppressWarnings("unchecked")
	public String list(@PathVariable int pno,Model model) {
		logger.info("MemberController!::::: member리스트 {}","진입" );
		pxy.setPageSize(5);
		pxy.setBlockSize(5);
		pxy.setPageNumber(pno);
		System.out.println(pno);
		int count=Integer.parseInt(service.count());
		model.addAttribute("count",count);
		pxy.setTheNumberOfRows(count);
		int []result=new int[6];
		int theNumberofPage=0, startPage=0 ,endPage=0;
		
		theNumberofPage=(pxy.getTheNumberOfRows()% pxy.getBlockSize()) == 0 ?
				pxy.getTheNumberOfRows()/pxy.getPageSize()
				: pxy.getTheNumberOfRows()/pxy.getPageSize() +1;
		startPage = pxy.getPageNumber()-((pxy.getPageNumber()-1)%pxy.getBlockSize());
		endPage = (startPage + pxy.getBlockSize()-1 <= theNumberofPage) ?
				startPage + pxy.getBlockSize() - 1 : theNumberofPage;
		result[0]=pxy.getPageNumber();
		result[1]=theNumberofPage;
		result[2]=startPage;
		result[3]=endPage;
		result[4]=(startPage-(theNumberofPage/pxy.getBlockSize())>0)?1:0;
		result[5]=startPage+pxy.getBlockSize();
		
		if(pxy.getPageNumber() <= pxy.getTheNumberOfRows()/pxy.getPageNumber() +1) {
			if(pxy.getPageNumber() == 1) {
				cmd.setStartRow("1");
				cmd.setEndRow(String.valueOf(pxy.getPageSize()));
			}else {
				cmd.setStartRow(String.valueOf(
						(pxy.getPageNumber() -1)* pxy.getPageSize() +1));
				
				cmd.setEndRow(String.valueOf(
						pxy.getPageNumber() * pxy.getPageSize()));
			}
			}
		List<StudentDTO> list=(List<StudentDTO>) service.list(cmd);
		pxy.execute(model,result,list);
		System.out.println("리스트에"+list);
		return "auth:member/member_list.tiles";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/search/{search}")
	public String memberSearch(@PathVariable String search, Model model) {
		logger.info("MemberController!::::: member써치 {}","진입" );
		cmd.setSearch(search);
		System.out.println("23123"+search);
		List<StudentDTO> list=(List<StudentDTO>) service.findByName(cmd);
		System.out.println("1111"+list);
		model.addAttribute("list",list);
		model.addAttribute("pageNumber","1");
		return "auth:member/member_list.tiles";
	}
	@RequestMapping("/delete/{id}")
	public String memberDelete(@PathVariable String id) {
		logger.info("MemberController!::::: memberDelete {}","진입" );
		System.out.println("딜리트할 아이디"+id);
		cmd.setSearch(id);
		service.removeUser(cmd);
		
		return "redirect:/member/list/1";
	}
	@RequestMapping("/detail/{id}")
	public String memberDetail(@PathVariable String id,Model model) {
		logger.info("MemberController!::::: memberDetail {}","진입" );
		System.out.println("디테일 아이디"+id);
		cmd.setSearch(id);
		
		StudentDTO list= service.findById(cmd);
		System.out.println("1111"+list);
		model.addAttribute("list",list);
		return "auth:member/member_detail.tiles";
	}
	@RequestMapping("/update")
	public String memberUpdate(@ModelAttribute MemberDTO stu) {
		logger.info("MemberController!::::: member업데이트 {}","진입" );
		System.out.println("d업데이트진입");
		service.modifiyProfile(stu);
		logger.info("넘어온값 {}" ,stu.getEmail());
		return "redirect:/member/list/1";
	}
}
