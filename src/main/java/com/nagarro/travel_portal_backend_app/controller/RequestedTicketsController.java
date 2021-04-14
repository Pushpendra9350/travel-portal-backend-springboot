package com.nagarro.travel_portal_backend_app.controller;

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
import com.nagarro.travel_portal_backend_app.model.RequestedTickets;
import com.nagarro.travel_portal_backend_app.service.RequestedTicketsService;

/**
 * This is Requested Tickets Controller
 * 
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class RequestedTicketsController {
	
	@Autowired
	private RequestedTicketsService requestedTicketsService;
	
	

	/**
	 * This moethod is used for create tickets.
	 * 
	 * @param emp_id
	 * @param requestedTickets
	 * @return this will return boolean value if tickets is created or not.
	 */

	
	@PostMapping("/{emp_id}/request-new-ticket")
	public ResponseEntity<Boolean> createNewTicket(@PathVariable long emp_id, @RequestBody RequestedTickets requestedTickets)
	{
		return ResponseEntity.ok().body(this.requestedTicketsService.createNewTicket(emp_id, requestedTickets));
	}

	/**
	 * This method for update tickets
	 * @param ticket_id
	 * @param requestedTickets
	 * @return Boolean value if tickets is updated or not 
	 */
	
	@PutMapping("/requested-ticket/update/{ticketId}")
	public ResponseEntity<Boolean> updateTicket(@PathVariable long ticketId, @RequestBody RequestedTickets requestedTickets)
	{
		return ResponseEntity.ok().body(this.requestedTicketsService.updateTicket(ticketId, requestedTickets));
	}

	/**
	 * This method is for find tickets on the basis of employee id
	 * @param emp_id
	 * @return List of Requested tickets
	 */
	
	@GetMapping("/requested-ticket/{empId}")
	public ResponseEntity<List<RequestedTickets>> findTicketsByEmpId(@PathVariable long empId)
	{
		return ResponseEntity.ok().body(this.requestedTicketsService.findTicketsByEmpId(empId));
	}

	/**
	 * This method for change Status
	 * @param ticket_id
	 * @param status
	 * @return String of status
	 */
	
	@PutMapping("/requested-ticket/{ticket_id}/status/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable long ticket_id,@PathVariable String status)
	{
		return ResponseEntity.ok().body(this.requestedTicketsService.changeStatusOfTicket(ticket_id, status));
	}
	
	
	@GetMapping("/requested-ticket/priority/{pri}")
	public ResponseEntity<List<RequestedTickets>> getbypriority(@PathVariable Integer pri)
	{
		return ResponseEntity.ok().body(this.requestedTicketsService.getallbypriority(pri));
	}
	

	@GetMapping("/requested-ticket/ticket/{ticketId}")
	public ResponseEntity<RequestedTickets> ticketByTicketId(@PathVariable long ticketId)
	{
		return ResponseEntity.ok().body(this.requestedTicketsService.findTicketByTicketId(ticketId));
	}
	
	
	
}
