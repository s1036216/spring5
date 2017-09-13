package com.gms.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.member.MemberService;

@Controller
@RequestMapping("/common")
public class CommonController {
	@Autowired MemberService service;
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	@RequestMapping("/path/{dir}/{page}")
	public String move(@PathVariable String dir,@PathVariable String page,Model model){
		model.addAttribute("count",service.count());
		logger.info("카운터 {}" , "진입");
		logger.info("common {}" , "진입");
		
		return String.format("auth:%s/%s.tiles",dir,page);
	}
}
