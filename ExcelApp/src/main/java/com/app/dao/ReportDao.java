package com.app.dao;

import java.util.HashMap;
import java.util.Map;

import com.app.model.Student;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ReportDao {
	private ISql icrud = DALHelper.getIsql();
	
	public int getMarksId(String name, String roll_no) throws DALException {
		
		Map<String, String> criteria = new HashMap<>();
		criteria.put("name", name);
		icrud.findBy(Student.class, criteria);
		return 0;
	}
}
