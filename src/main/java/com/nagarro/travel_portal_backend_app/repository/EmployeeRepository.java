package com.nagarro.travel_portal_backend_app.repository;



/**
 * This is Employee Repository interface
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nagarro.travel_portal_backend_app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	@Query(value="select count(email) from employees where email=?1",nativeQuery=true)
	int countEmployeeByEmail(String email);
	
	
	@Query(value="select * from employees where email=?1",nativeQuery=true)
	Optional<Employee> getEmployeeByEmail(String email);
	
	
	Optional<List<Employee>> findAllByBusinessUnit(String BusinessUnit);
	Optional<Employee>findAllByFirstName(String firstName);

}
