package com.service.impl;

import com.dao.CompileMateriaDao;
import com.domain.CompileMateria;
import com.service.CompileMateriaService;

public class CompileMateriaServiceImpl extends BaseServiceImpl<CompileMateria>
		implements CompileMateriaService {

	private CompileMateriaDao compileMateriaDao;

	public void setCompileMateriaDao(CompileMateriaDao compileMateriaDao) {
		this.compileMateriaDao = compileMateriaDao;
		super.setBaseDao(compileMateriaDao);
	}
	
	

}
