package com.app.service;

import com.app.dao.ReportDao;

import mkcl.os.model.dal.DALException;

public class ReportService {
	
	ReportDao rDao = new ReportDao();
	public int getMarksId(String name, String roll_no) {
		// TODO Auto-generated method stub
		try {
			return rDao.getMarksId(name, roll_no);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
