package com.nagarro.travel_portal_backend_app.service;

/**
 * This is Employee service interface
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import com.nagarro.travel_portal_backend_app.model.Employee;
import com.nagarro.travel_portal_backend_app.model.LoginDetails;

public interface EmployeeService {

	boolean createEmployee(Employee employee);

	Employee updateEmployee(long id, Employee employee);

	boolean getForgetDetails(String email);

	LoginDetails validateEmployee(String email, String passward);
}
