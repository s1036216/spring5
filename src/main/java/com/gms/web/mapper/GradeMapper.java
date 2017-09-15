package com.gms.web.mapper;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gms.web.grade.MajorDTO;

@Repository 
public interface GradeMapper {
	public int insertMajor(List<MajorDTO> list);
}
