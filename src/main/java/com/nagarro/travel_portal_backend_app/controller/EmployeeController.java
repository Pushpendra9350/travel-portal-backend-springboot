package com.nagarro.travel_portal_backend_app.controller;

/**
 * This is Employee Controller class.
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.travel_portal_backend_app.model.Employee;
import com.nagarro.travel_portal_backend_app.model.LoginDetails;
import com.nagarro.travel_portal_backend_app.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	


	/**
	 * This method is used for creating the emoployee or register method.
	 * @param employee This is object of employee type.
	 * @return Boolean value if user created or not.
	 */
	
	@PostMapping("/register-employee")
	public ResponseEntity<Boolean> createNewEmployee(@RequestBody Employee employee)
	{
		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
	}

	/**
	 * This method is use for getting user password/ forget password Method
	 * @param email  
	 * @return This is send the password in to your email account.
	 */
	
	@GetMapping("/employee/{email}")
	public ResponseEntity<Boolean> getUsernamePassword(@PathVariable String email)
	{
		return ResponseEntity.ok().body(this.employeeService.getForgetDetails(email));
	}


	/**
	 * This is login Method for empoloyee.
	 * @param email
	 * @param passward
	 * @return This will give the boolean value.
	 */
	
	@PostMapping("/employee-login/{email}/{passward}")
	public ResponseEntity<LoginDetails> employeeLogin(@PathVariable String email, @PathVariable String passward)
	{
		return ResponseEntity.ok().body(this.employeeService.validateEmployee(email,passward));
	}


}
