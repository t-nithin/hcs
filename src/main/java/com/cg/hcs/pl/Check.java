package com.cg.hcs.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.exception.HealthException;
import com.cg.hcs.service.HealthService;
import com.cg.hcs.service.HealthServiceImpl;

public class Check {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	HealthService healthService=new HealthServiceImpl();
	 DiagnosticCenter  diagnosticCenter = new  DiagnosticCenter();
	 Test test = new Test();
	 int choice=0;
	 List<DiagnosticCenter> list =null;
	 List<Test> list1=null;
	 while(choice!=4)
		{

			System.out.println("1.List of available tests");
			
			System.out.println("2.delete test");
			System.out.println("3.exit");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				
				list = healthService.findAllDiagnosticCenter();
				for( DiagnosticCenter  center:list)
				{
					int centerId=center.getCenterId();
					String centerName = center.getCenterName();
					System.out.println("center ID = "+centerId+" center name = "+centerName);
					list1 = healthService.findAllTests();
					System.out.println("Tests available in the center");
					for( Test test1:list1)
					{
						String testId=test1.getTestId();
						String testName = test1.getTestName();
						System.out.println("Test Id = "+testId+" test Name = "+testName);

					}
					System.out.println();
				}
				
				
				break;
			
			case 2:
				sc.nextLine();
				System.out.println("Choose the diagonistic center");
				String center = sc.nextLine();
				System.out.println("Choose the testId");
				String testId = sc.nextLine();
				String id = test.setTestId(testId);
				try
				{
					healthService.removeTest(center, diagnosticCenter,test);
					System.out.println(testId+" is deleted");
				}
				catch (HealthException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				return;
			}
		}
}
}
