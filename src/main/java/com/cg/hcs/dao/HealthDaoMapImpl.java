package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.exception.HealthException;

public class HealthDaoMapImpl implements HealthDao{
	private Map<String,DiagnosticCenter> map;
	private Map<String,Test> map2;
	List<DiagnosticCenter> list1;
List<Test> list;
	public HealthDaoMapImpl()
	{
		map = new HashMap<String,DiagnosticCenter>();
		map2 = new HashMap<String,Test>();
		Test t1 = new Test("101","BP test");
		Test t2 = new Test("102","sugar test");
		Test t3 = new Test("103","MRI");
		Test t4 = new Test("104","ECG");
		Test t5 = new Test("105","Urine test");
		 list = new LinkedList<Test>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.remove(t3);
		DiagnosticCenter d1 = new DiagnosticCenter(1001,"Vijaya",list);
		DiagnosticCenter d2 = new DiagnosticCenter(1002,"yashoda",list);
		DiagnosticCenter d3 = new DiagnosticCenter(1003,"keerthi",list);
		DiagnosticCenter d4 = new DiagnosticCenter(1004,"Tulasi",list);
	list1 = new LinkedList<DiagnosticCenter>();
		list1.add(d1);
		list1.add(d2);
		list1.add(d3);
		list1.add(d4);
		map.put("vijaya", d1);
		map.put("yashoda", d1);
		map.put("keerth", d1);
		map.put("Tulasi", d1);
		
	}
	
	@Override
	public String removeTest(String centerName, DiagnosticCenter diagnosticCenter,Test test) throws HealthException {
		boolean flag = map.containsKey(centerName) ;
		if(flag)
		{
			DiagnosticCenter diagnosticCenter1 = map.get(centerName) ;
			List<Test> list2 = diagnosticCenter1.getListOfTests();
			
		
			boolean flag2=list2.stream().anyMatch(p->p.getTestId().equals(test.getTestId())?true:false);
			
				if(flag2)
				{
					list2.remove(test);
					
				}
				else
				{
					throw new HealthException(test.getTestId()+" id is not found");
				}
					
		}	
		
		
		else
		{
			throw new HealthException(centerName+" center is not found");
		}
		return test.getTestId();
	}

	@Override
	public List<DiagnosticCenter> findAllDiagnosticCenter() {
	
		return list1;
	}

	@Override
	public List<Test> findAllTests()  {
		
		return list;
	}
	

}
