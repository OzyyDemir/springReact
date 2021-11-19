package com.myApp.myApp.business.abstracts;

import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.entities.concretes.Opinion;

public interface OpinionService {
	
	Result add(Opinion opinion);
}
