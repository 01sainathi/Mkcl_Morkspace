package com.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.model.Mark;
import com.app.model.School;
import com.app.model.Student;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ReportDao {
	
	private ISql icrud = DALHelper.getIsql();
	
	public Student getStudent(String name, String roll_no) throws Exception {
		
		Map<String, String> criteria = new HashMap<>();
		criteria.put("name", name);
		criteria.put("rollNo", roll_no);
		List<Student> list = ((ArrayList<Student>)icrud.findBy(Student.class, criteria));
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public Mark getMarks(Map<String, Integer> criteria) throws DALException {
		// TODO Auto-generated method stub
		List<Mark> list = icrud.findBy(Mark.class, criteria);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public School getSchool(Map<String, Integer> criteria) throws DALException {
		// TODO Auto-generated method stub
		List<School> list = icrud.findBy(School.class, criteria);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
