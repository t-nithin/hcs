package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.dao.HealthDao;
import com.cg.hcs.dao.HealthDaoMapImpl;
import com.cg.hcs.exception.HealthException;

public class HealthServiceImpl implements HealthService {
private HealthDao healthDao;
public  HealthServiceImpl()
{
	healthDao = new HealthDaoMapImpl();
}
@Override
public String removeTest(String centerName, DiagnosticCenter diagnosticCenter,Test test) throws HealthException {
	
	return healthDao.removeTest(centerName, diagnosticCenter,test);
}
@Override
public List<DiagnosticCenter> findAllDiagnosticCenter()  {
	
	return healthDao.findAllDiagnosticCenter();
}
@Override
public List<Test> findAllTests()  {
	
	return healthDao.findAllTests( );
}


}
