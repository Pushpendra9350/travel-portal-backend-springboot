package com.nagarro.travel_portal_backend_app.repository;

/**
 * This is Admin Repository interface
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nagarro.travel_portal_backend_app.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	@Query(value="select count(email) from admin where email=?1",nativeQuery=true)
	int countAdminByEmail(String email);
	
	
	@Query(value="select * from admin where email=?1",nativeQuery=true)
	Optional<Admin> getAdminByEmail(String email);
	
	
}
