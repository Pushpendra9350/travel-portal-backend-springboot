package com.nagarro.travel_portal_backend_app.repository;


/**
 * This is Requested Tickets Repository interface
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
import com.nagarro.travel_portal_backend_app.model.RequestedTickets;

@Repository
public interface RequestedTicketsRepository extends JpaRepository<RequestedTickets, Long>{

	
	
	// correct
	@Query(value="SELECT * from requested_tickets where emp_id=?1",nativeQuery = true)
	Optional<List<RequestedTickets>> findTicketsByEmployeeId(long emp_id);
	
	//List<RequestedTickets>findAllByCreatedAtSorted(LocalDate createdAt);
	List<RequestedTickets>findAllByPriority(Integer priority);
	List<RequestedTickets>findAllByProjectName(String projectName);
	
	@Query(value="select * from requested_tickets order by created_at;",nativeQuery = true)
	List<RequestedTickets>findAllByOrderBytravelStartDateAsc();
	
	List<RequestedTickets>findAllByToTravelCity(String toTravelCity);
	//List<RequestedTickets>findAllByStatus(String status);
	
	@Query(value="SELECT * from requested_tickets where  status = ('SUBMITTED' AND 'RESUBMITTED' AND 'INPROCESS')",nativeQuery = true)
	List<RequestedTickets>findAllByStatus();
	
	@Query(value="SELECT * from requested_tickets where emp_id=?1",nativeQuery = true)
	List<RequestedTickets>findAllByBu(long empId);
	
//	@Query(value="SELECT * from requested_tickets where emp_id=?1",nativeQuery = true)
//	List<RequestedTickets> findOneByBu(long empId );
	
}