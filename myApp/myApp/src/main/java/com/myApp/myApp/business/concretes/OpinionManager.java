package com.myApp.myApp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp.myApp.business.abstracts.OpinionService;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.core.utilities.results.SuccessResult;
import com.myApp.myApp.dataAccess.abstracts.OpinionDao;
import com.myApp.myApp.entities.concretes.Opinion;

@Service
public class OpinionManager implements OpinionService{
	
	OpinionDao opinionDao;
	
	@Autowired
	public OpinionManager(OpinionDao opinionDao) {
		super();
		this.opinionDao = opinionDao;
	}

	@Override
	public Result add(Opinion opinion) {
		this.opinionDao.save(opinion);
		return new SuccessResult("Data added");
	}

}
