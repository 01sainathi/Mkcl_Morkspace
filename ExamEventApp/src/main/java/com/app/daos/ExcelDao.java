package com.app.daos;

import java.util.List;

import com.app.models.ExamEvent;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ExcelDao {
	
	private ISql icrud = DALHelper.getIsql();
	
	public String save(List<ExamEvent> list) throws DALException{
		
		icrud.saveCollection(list);
		
		return "Successfully Added";
	}
}
