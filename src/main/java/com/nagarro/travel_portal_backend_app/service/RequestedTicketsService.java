package com.nagarro.travel_portal_backend_app.service;

/**
 * This is Requested Tickets service interface
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import java.util.List;

import com.nagarro.travel_portal_backend_app.model.RequestedTickets;

public interface RequestedTicketsService {

	// Create new ticket
	Boolean createNewTicket(long empId, RequestedTickets requestedTickets);

	// Update a ticket
	Boolean updateTicket(long ticketId, RequestedTickets requestedTickets);

	List<RequestedTickets> findTicketsByEmpId(long empId);

	String changeStatusOfTicket(long ticketId, String status);

	List<RequestedTickets> getallbypriority(Integer priority);

	RequestedTickets findTicketByTicketId(long ticketId);

}
