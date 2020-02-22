package com.cg.hcs.dao;

import java.util.List;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.exception.HealthException;

public interface HealthDao {
	public String removeTest(String centerName,DiagnosticCenter diagnosticCenter,Test test) throws HealthException;
	public List<DiagnosticCenter> findAllDiagnosticCenter();
	public List<Test> findAllTests()  ;
}
