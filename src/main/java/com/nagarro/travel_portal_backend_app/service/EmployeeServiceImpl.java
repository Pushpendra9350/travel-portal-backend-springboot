package com.nagarro.travel_portal_backend_app.service;

/**
 * This is Employee Service Implementation class.
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nagarro.travel_portal_backend_app.exception.ResourceNotFoundException;
import com.nagarro.travel_portal_backend_app.model.Employee;
import com.nagarro.travel_portal_backend_app.model.LoginDetails;
import com.nagarro.travel_portal_backend_app.repository.EmployeeRepository;

@Service
@Transactional()
public class EmployeeServiceImpl implements EmployeeService {

	// Dependency injection
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private MailService mailService;

	/**
	 * This method is used for creating the emoployee or register method.
	 * 
	 * @param employee
	 *            This is object of employee type.
	 * @return Boolean value if user created or not.
	 */

	@Override
	public boolean createEmployee(Employee employee) {
		int emailCount = this.employeeRepository.countEmployeeByEmail(employee.getEmail());
		if (emailCount == 0) {
			String reciever = employee.getEmail();
			try {
				try {
					mailService.sendMailForRegistration(reciever, employee);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} catch (MailException e) {
				// logger.info("Error message is : "+e.getMessage());
				System.out.println("Error message is : " + e.getMessage());
			}
			employeeRepository.save(employee);

			return true;
		} else {

			return false;
		}
	}

	/**
	 * This method is use for getting user password/ forget password Method
	 * 
	 * @param email
	 * @return This is send the password in to your email account.
	 */
	@Override
	public boolean getForgetDetails(String email) {
		Optional<Employee> emailpass = this.employeeRepository.getEmployeeByEmail(email);
		if (emailpass.isPresent()) {
			int flag = 0;
			Employee emailpassdata = emailpass.get();
			String reciever = email;
			try {
				try {
					mailService.sendMailForForgetPassword(reciever, emailpassdata);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} catch (MailException e) {
				// logger.info("Error message is : "+e.getMessage());
				System.out.println("Error message is : " + e.getMessage());
				flag = 1;
			}
			if (flag == 0) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * This is validation Method for empoloyee.
	 * 
	 * @param email
	 * @param passward
	 * @return This will give the boolean value.
	 */

	@Override
	public LoginDetails validateEmployee(String email, String passward) {
		int count = this.employeeRepository.countEmployeeByEmail(email);
		if (count != 0) {
			Optional<Employee> employee = this.employeeRepository.getEmployeeByEmail(email);
			if (employee.isPresent()) {
				Employee employeedata = employee.get();
				String pass = employeedata.getPassward();
				if (pass.equals(passward)) {
					LoginDetails details = new LoginDetails();
					details.setYes(true);
					details.setEmpId(employeedata.getEmpId());
					return details;
				} else {
					LoginDetails details = new LoginDetails();
					details.setYes(false);
					details.setEmpId(0);
					return details;
				}
			} else {
				throw new ResourceNotFoundException("Data Not found");
			}
		} else {

			throw new ResourceNotFoundException("Please register you are not registered");
		}
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Optional<Employee> employeedb = this.employeeRepository.findById(id);
		if (employeedb.isPresent()) {
			Employee employeeUpdate = employeedb.get();
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setBusinessUnit(employee.getBusinessUnit());
			employeeUpdate.setTitle(employee.getTitle());
			employeeUpdate.setEmail(employee.getEmail());
			employeeUpdate.setTelephone(employee.getTelephone());
			employeeUpdate.setAddressOne(employee.getAddressOne());
			employeeUpdate.setAddressTwo(employee.getAddressTwo());
			employeeUpdate.setCity(employee.getCity());
			employeeUpdate.setState(employee.getState());
			employeeUpdate.setZip(employee.getZip());
			employeeUpdate.setCountry(employee.getCountry());
			employeeUpdate.setPassward(employee.getPassward());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found");
		}
	}

}
