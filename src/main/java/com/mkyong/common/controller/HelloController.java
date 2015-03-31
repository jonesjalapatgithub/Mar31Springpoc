package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cybage.assignment.decassignment.EmpBusinessLogic;
import com.cybage.assignment.decassignment.EmployeeDetails;

@Controller
@RequestMapping("/welcome")
public class HelloController {

	EmpBusinessLogic empBusinessObject = new EmpBusinessLogic();
	EmployeeDetails  empDetailsObject = new EmployeeDetails();
	@RequestMapping(method = RequestMethod.GET)
	public String calculateTotalSalary(ModelMap model) {
		empDetailsObject.setName("Jones");
		empDetailsObject.setAge(23);
		empDetailsObject.setMonthlySalary(21000);
		double appraisal=empBusinessObject.calculateAppraisal(empDetailsObject);
		double salary=empBusinessObject.calculateYearlySalary(empDetailsObject);
		double totalSalary=appraisal+salary;
		model.addAttribute("totalSalary", "appraisal - "+appraisal+"\n"+"salary - "+salary+"\n"+"totalsalary - "+totalSalary);
		return "hello";

	}
	
}