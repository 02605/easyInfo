package com.service.impl;

import com.dao.InstructorDao;
import com.domain.Instructor;
import com.service.InstructorService;

public class InstructorServiceImpl extends BaseServiceImpl<Instructor>
		implements InstructorService {

	private InstructorDao instructorDao;

	public void setInstructorDao(InstructorDao instructorDao) {
		this.instructorDao = instructorDao;
		super.setBaseDao(instructorDao);
	}
	
}
