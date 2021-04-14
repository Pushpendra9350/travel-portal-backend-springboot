package com.nagarro.travel_portal_backend_app.controller;


/**
 * This is Admin Controller
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.travel_portal_backend_app.model.LoginDetails;
import com.nagarro.travel_portal_backend_app.model.RequestedTickets;
import com.nagarro.travel_portal_backend_app.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * This is validation Admin method. It is just to use to varify that 
	 * given Admin is valid or not.
	 * 
	 * @param email This is first parameter of adminLogin method.
	 * @param password This is second parameter of adminLogin method.
	 * @ return This will return boolean value on the basis of given data.
	 * 
	 */
	
	@PostMapping("/admin-login/{email}/{passward}")
	public ResponseEntity<LoginDetails> adminLogin(@PathVariable String email, @PathVariable  String passward)
	{
		return ResponseEntity.ok().body(this.adminService.validateAdmin(email, passward));
	}
	
	
	/**
	 * This method is used to update comments and other data by admin
	 * @param ticket_id This is first parameter of udateComments method.
	 * @return List of all Requested Tickets.
	 */

	@PutMapping("/admin/AllTickets/updateComment/{ticketId}")
	public ResponseEntity<Boolean> updateComment(@PathVariable long ticketId,@RequestBody RequestedTickets requestedTickets)
	{
	return ResponseEntity.ok().body(this.adminService.updateCommentOfTicket(ticketId, requestedTickets));
	}
	

	/**
	 * This method is used to update comments and other data by admin
	 * @param ticket_id This is first parameter of udateComments method.
	 * @return List of all Requested Tickets.
	 */
	
	@GetMapping("/admin/All-tickets")
	public ResponseEntity<List<RequestedTickets>> getAllTickets()
	{
		return ResponseEntity.ok().body(this.adminService.gettingAllTickets());
	}

	
	
	/**
	 * This method is for Sort all tickets on the bases of priority.
	 * @param adminName This is first parameter of ticketsSortByPriority method.
	 * @return List of all sorted tickets on the basis of priority. 
	 */
	
	@GetMapping("/admin/sortby-priority")
	public ResponseEntity<List<RequestedTickets>> ticketsSortByPriority()
	{
		return ResponseEntity.ok().body(this.adminService.SortByPriorityAllTickets());
	}

	
	/**
	 * This method is used for sort all tickets on the bases of submission Date. 
	 * @param adminName This is first parameter of ticketsSortBySubmissionDate method.
	 * @return List of sorted tickets on the basis of submission date.
	 */

	@GetMapping("/admin/sortby-submissiondate")
	public ResponseEntity<List<RequestedTickets>> ticketsSortBySubmissionDate()
	{
	return ResponseEntity.ok().body(this.adminService.SortBySubmissionDateAllTickets());
	}

	/**
	 * This method is used for filter all tickets on the bases of priority. 
	 * @param priority This is first parameter of ticketsSortBySubmissionDate method.
	 * @return List of sorted tickets on the basis of submission date.
	 */

	@GetMapping("/admin/filterby-priority/{priority}")
	public ResponseEntity<List<RequestedTickets>> FilterByPriority(@PathVariable Integer priority)
	{
	return ResponseEntity.ok().body(this.adminService.FilterByPriorityAllTickets(priority));
	}
	
	
	/**
	 * This method is used for filter all tickets on the bases of project Name. 
	 * @param priority This is first parameter of ticketsfilterBySubmissionDate method.
	 * @return List of sorted tickets on the basis of submission date.
	 */
	
	
	
	@GetMapping("/admin/filterby-projectName/{projectName}")
	public ResponseEntity<List<RequestedTickets>> filterBySubmissionDate(@PathVariable String projectName)
	{
	return ResponseEntity.ok().body(this.adminService.FilterByProjectNameAllTickets(projectName));
	}
	
	
	/**
	 * This method is used for filter all tickets on the bases of firstname. 
	 * @param priority This is first parameter of FilterByPersonAllTickets method.
	 * @return List of sorted tickets on the basis of submission date.
	 */
	
	@GetMapping("/admin/filterby-personName/{firstName}")
	public ResponseEntity<List<RequestedTickets>> filterByPerson(@PathVariable String firstName)
	{
	return ResponseEntity.ok().body(this.adminService.FilterByPersonAllTickets(firstName));
	}
	
	/**
	 * This method is used for filter all tickets on the bases of firstname. 
	 * @param priority This is first parameter of FilterByPersonAllTickets method.
	 * @return List of sorted tickets on the basis of submission date.
	 */
	
	
	@GetMapping("/admin/filterby-toTravelCity/{toTravelCity}")
	public ResponseEntity<List<RequestedTickets>> filterByToTravelCity(@PathVariable String toTravelCity)
	{
	return ResponseEntity.ok().body(this.adminService.FilterByTravelCityAllTickets(toTravelCity));
	}
	


	
}
