package com.gms.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gms.web.board.BoardController;

@Controller 
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/grade_add")
	public String gradeAdd() {
     logger.info("GradeController::::: gradeAdd {}","진입");
		return "auth:grade/grade_add.tiles";
	}
	@RequestMapping("/grade_list")
	public String gradeList() {
	   logger.info("GradeController::::: gradeList {}","진입");
		return "auth:grade/grade_list.tiles";
	}
	@RequestMapping("/grade_detail")
	public String gradeDetail() {
	   logger.info("GradeController::::: gradeDetail {}","진입");
		return "auth:grade/grade_detail.tiles";
	}
	@RequestMapping("/grade_update")
	public String gradeUpdate() {
		logger.info("GradeController::::: gradeUpdate {}","진입");
		return "auth:grade/grade_update.tiles";
	}
	@RequestMapping("/grade_delete")
	public String gradeDelete() {
		logger.info("GradeController::::: gradeUpdate {}","진입");
		return "auth:grade/grade_list.tiles";
	}
}
