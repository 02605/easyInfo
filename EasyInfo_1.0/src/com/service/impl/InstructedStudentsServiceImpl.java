package com.service.impl;

import com.dao.InstructedStudentsDao;
import com.domain.InstructedStudents;
import com.service.InstructedStudentsService;

public class InstructedStudentsServiceImpl extends
		BaseServiceImpl<InstructedStudents> implements
		InstructedStudentsService {

	private InstructedStudentsDao instructedStudentsDao;

	public void setInstructedStudentsDao(InstructedStudentsDao instructedStudentsDao) {
		this.instructedStudentsDao = instructedStudentsDao;
		super.setBaseDao(instructedStudentsDao);
	}
	
	
}
