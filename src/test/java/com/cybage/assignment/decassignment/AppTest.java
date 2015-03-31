package com.cybage.assignment.decassignment;

import junit.framework.TestCase;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import com.mkyong.common.controller.HelloController;


@RunWith(MockitoJUnitRunner.class)
public class AppTest 
    extends TestCase{
	@Mock private ModelMap model;
	@Mock EmpBusinessLogic empBusinessLogic;
	@Mock EmployeeDetails employee;
	
	String a="Rajeev";
	//EmpBusinessLogic empBusinessLogic =new EmpBusinessLogic();
	   //EmployeeDetails employee = new EmployeeDetails();

	@Before //so that duplicate codes are reduced
	public void setUp(){
		
	}
    //Testing of EmployeeDetails class
    @Test
    public void testEmployeeDetails(){
    	EmployeeDetails employeeReal = new EmployeeDetails();
    	employeeReal.setName(a);
    	employeeReal.setAge(25); 
    	employeeReal.setMonthlySalary(8000);
        double compareSalary = employeeReal.getMonthlySalary();
        assertEquals(compareSalary,  8000.0);
 
   
    }
    //Testing of EmployeeBussinessLogic Class
    @Test
    public void testEmpBusinessLogic(){
          when(employee.getMonthlySalary()).thenReturn((double) 8000);
          
          double compareSalary1 = employee.getMonthlySalary();
          verify(employee).getMonthlySalary();
          assertEquals(compareSalary1, (double) 8000);
          EmpBusinessLogic empBusinessLogicReal = new EmpBusinessLogic();
          double appraisal1=empBusinessLogicReal.calculateAppraisal(employee);
    	  double yearsalary1=empBusinessLogicReal.calculateYearlySalary(employee);
    	  assertEquals(appraisal1,  (double)500);
    	  assertEquals(yearsalary1, (double)(8000 * 12));
    	  
    	  when(employee.getMonthlySalary()).thenReturn((double) 12000);
          
          double compareSalary2 = employee.getMonthlySalary();
//          verify(employee).getMonthlySalary();
          assertEquals(compareSalary2, (double) 12000);
          double appraisal2=empBusinessLogicReal.calculateAppraisal(employee);
    	  double yearsalary2=empBusinessLogicReal.calculateYearlySalary(employee);
    	  assertEquals(appraisal2, (double) 1000);
    	  assertEquals(yearsalary2, (double) (12000 * 12));	  
    }
    
    @Test
    public void testController(){
    	HelloController controllerObject = new HelloController();
    	when(empBusinessLogic.calculateAppraisal(employee)).thenReturn((double)500);
    	double appraisal = empBusinessLogic.calculateAppraisal(employee);
        assertEquals(appraisal, (double) 500);
    	when(empBusinessLogic.calculateYearlySalary(employee)).thenReturn((double)22500);
    	double salary = empBusinessLogic.calculateYearlySalary(employee);
        assertEquals(salary, (double) 22500);
        double totalSalary=appraisal+salary;
        when(model.addAttribute("totalSalary", "appraisal - "+appraisal+"\n"+"salary - "+salary+"\n"+"totalsalary - "+totalSalary)).thenReturn(model);
        controllerObject.calculateTotalSalary(model);
        
    }
}







