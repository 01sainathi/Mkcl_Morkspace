package com.app.service;

import java.util.HashMap;
import java.util.Map;

import com.app.dao.ReportDao;
import com.app.model.Mark;
import com.app.model.School;
import com.app.model.Student;

import mkcl.os.model.dal.DALException;

public class ReportService {
	
	ReportDao rDao = new ReportDao();
	
	public Student getStudent(String name, String roll_no) {
		// TODO Auto-generated method stub
		try {
			return rDao.getStudent(name, roll_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Mark getMarks(int fkMarkId) {
		// TODO Auto-generated method stub
		Map<String, Integer> criteria = new HashMap<>();
		criteria.put("markId", fkMarkId);
		try {
			return rDao.getMarks(criteria);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public School getSchool(int fkSchoolId) {
		// TODO Auto-generated method stub
		Map<String, Integer> criteria = new HashMap<>();
		criteria.put("schoolId",fkSchoolId);
		
		try {
			return rDao.getSchool(criteria);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
