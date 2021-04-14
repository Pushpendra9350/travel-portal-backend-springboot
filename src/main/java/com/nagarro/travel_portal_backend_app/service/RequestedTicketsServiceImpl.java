package com.nagarro.travel_portal_backend_app.service;

/**
 * This is Requested Tickets Service class
 * 
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.travel_portal_backend_app.exception.ResourceNotFoundException;
import com.nagarro.travel_portal_backend_app.model.RequestedTickets;
import com.nagarro.travel_portal_backend_app.repository.RequestedTicketsRepository;

@Service
@Transactional
public class RequestedTicketsServiceImpl implements RequestedTicketsService {

	@Autowired
	private RequestedTicketsRepository requestedTicketsRepository;

	/**
	 * This moethod is used for create tickets.
	 * 
	 * @param emp_id
	 * @param requestedTickets
	 * @return this will return boolean value if tickets is created or not.
	 */
	@Override
	public Boolean createNewTicket(long emp_id, RequestedTickets requestedTickets) {
		if (requestedTickets != null) {
			requestedTickets.setEmpId(emp_id);
			requestedTicketsRepository.save(requestedTickets);
			return true;
		} else {
			throw new ResourceNotFoundException("Data not found");
		}
	}

	/**
	 * This method for update tickets
	 * 
	 * @param ticket_id
	 * @param requestedTickets
	 * @return Boolean value if tickets is updated or not
	 */
	@Override
	public Boolean updateTicket(long ticket_id, RequestedTickets requestedTickets) {
		Optional<RequestedTickets> ticket = this.requestedTicketsRepository.findById(ticket_id);
		if (ticket.isPresent()) {
			RequestedTickets ticketdata = ticket.get();
			ticketdata.setRequestType(requestedTickets.getRequestType());
			ticketdata.setPassportNumber(requestedTickets.getPassportNumber());
			ticketdata.setPriority(requestedTickets.getPriority());
			ticketdata.setProjectName(requestedTickets.getProjectName());
			ticketdata.setTravelEndDate(requestedTickets.getTravelEndDate());
			ticketdata.setTravelStartDate(requestedTickets.getTravelStartDate());
			ticketdata.setToTravelCity(requestedTickets.getToTravelCity());
			ticketdata.setFromTravelCity(requestedTickets.getFromTravelCity());
			ticketdata.setExpenseBorneBy(requestedTickets.getExpenseBorneBy());
			ticketdata.setTravelApproverName(requestedTickets.getTravelApproverName());
			ticketdata.setDurationOfTravel(requestedTickets.getDurationOfTravel());
			ticketdata.setUpperBoundAmount(requestedTickets.getUpperBoundAmount());
			ticketdata.setAdditionalComments(requestedTickets.getAdditionalComments());
			requestedTicketsRepository.save(ticketdata);
			return true;
		} else {
			throw new ResourceNotFoundException("Ticket is not present with " + ticket_id);
		}
	}

	/**
	 * This method is for find tickets on the basis of employee id
	 * 
	 * @param emp_id
	 * @return List of Requested tickets
	 */

	@Override
	public List<RequestedTickets> findTicketsByEmpId(long empId) {
		Optional<List<RequestedTickets>> tickets = this.requestedTicketsRepository.findTicketsByEmployeeId(empId);
		if (tickets.isPresent()) {
			List<RequestedTickets> ticketsdata = tickets.get();
			return ticketsdata;
		} else {
			throw new ResourceNotFoundException("Tickets not found with employee id " + empId);
		}
	}

	/**
	 * This method for change Status
	 * 
	 * @param ticket_id
	 * @param status
	 * @return String of status
	 */

	@Override
	public String changeStatusOfTicket(long ticketId, String status) {
		Optional<RequestedTickets> ticket = this.requestedTicketsRepository.findById(ticketId);
		if (ticket.isPresent()) {
			RequestedTickets ticketdata = ticket.get();
			ticketdata.setStatus(status);
			requestedTicketsRepository.save(ticketdata);
			return status;
		} else {
			throw new ResourceNotFoundException("This ticket is not present");
		}
	}

	@Override
	public List<RequestedTickets> getallbypriority(Integer priority) {
		return this.requestedTicketsRepository.findAllByPriority(priority);
	}

	@Override
	public RequestedTickets findTicketByTicketId(long ticketId) {
		Optional<RequestedTickets> tiket = this.requestedTicketsRepository.findById(ticketId);
		if (tiket.isPresent()) {
			RequestedTickets ticketData = tiket.get();
			return ticketData;
		} else {
			throw new ResourceNotFoundException("There is no ticket with this id");
		}
	}

}
