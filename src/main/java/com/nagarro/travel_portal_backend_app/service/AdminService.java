package com.nagarro.travel_portal_backend_app.service;

/**
 * This is Admin service interface
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import java.util.List;
import com.nagarro.travel_portal_backend_app.model.LoginDetails;
import com.nagarro.travel_portal_backend_app.model.RequestedTickets;

public interface AdminService {

	LoginDetails validateAdmin(String email, String passward);

	List<RequestedTickets> gettingAllTickets();

	List<RequestedTickets> SortByPriorityAllTickets();

	List<RequestedTickets> SortBySubmissionDateAllTickets();

	List<RequestedTickets> FilterByPriorityAllTickets(Integer priority);

	List<RequestedTickets> FilterByProjectNameAllTickets(String projectName);

	List<RequestedTickets> FilterByPersonAllTickets(String firstName);

	List<RequestedTickets> FilterByTravelCityAllTickets(String toTravelCity);

	// List<RequestedTickets> FilterByStatusAllTickets(String status);

	// List<RequestedTickets> findAllByOrderBytravelStartDateAsc();

	boolean updateCommentOfTicket(long ticketId, RequestedTickets requestedTickets);

}
