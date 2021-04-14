package com.nagarro.travel_portal_backend_app.service;

/**
 * This is Admin Service Implementation.
 * @author Pushpendra Kumar.
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.nagarro.travel_portal_backend_app.exception.ResourceNotFoundException;
import com.nagarro.travel_portal_backend_app.model.Admin;
import com.nagarro.travel_portal_backend_app.model.Employee;
import com.nagarro.travel_portal_backend_app.model.LoginDetails;
import com.nagarro.travel_portal_backend_app.model.RequestedTickets;
import com.nagarro.travel_portal_backend_app.repository.AdminRepository;
import com.nagarro.travel_portal_backend_app.repository.EmployeeRepository;
import com.nagarro.travel_portal_backend_app.repository.RequestedTicketsRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository AdminRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RequestedTicketsRepository requestedTicketsRepository;

	/**
	 * This is validation Admin method. It is just to use to varify that given Admin
	 * is valid or not.
	 * 
	 * @param email
	 *            This is first parameter of adminLogin method.
	 * @param password
	 *            This is second parameter of adminLogin method. @ return This will
	 *            return boolean value on the basis of given data.
	 * 
	 */

	@Override
	public LoginDetails validateAdmin(String email, String passward) {
		int count = this.AdminRepository.countAdminByEmail(email);
		if (count != 0) {
			Optional<Admin> admin = this.AdminRepository.getAdminByEmail(email);
			if (admin.isPresent()) {
				Admin admindata = admin.get();
				String pass = admindata.getPassward();
				if (pass.equals(passward)) {
					LoginDetails details = new LoginDetails();
					details.setYes(true);
					details.setEmpId(admindata.getAdminId());
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

			throw new ResourceNotFoundException("you are not registered");
		}
	}

	/**
	 * This method is used to get all tickets generated by users.
	 * 
	 * @param admin_id
	 *            This is first parameter of getAllTickets method.
	 * @return List of all Requested Tickets.
	 */

	@Override
	public List<RequestedTickets> gettingAllTickets() {

		return this.requestedTicketsRepository.findAllByStatus();
	}

	/**
	 * This method is for Sort all tickets on the bases of priority.
	 * 
	 * @param adminName
	 *            This is first parameter of ticketsSortByPriority method.
	 * @return List of all sorted tickets on the basis of priority.
	 */
	@Override
	public List<RequestedTickets> SortByPriorityAllTickets() {
		return this.requestedTicketsRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
	}

	/**
	 * This method is used for sort all tickets on the bases of submission Date.
	 * 
	 * @param adminName
	 *            This is first parameter of ticketsSortBySubmissionDate method.
	 * @return List of sorted tickets on the basis of submission date.
	 */
	@Override
	public List<RequestedTickets> SortBySubmissionDateAllTickets() {
		return this.requestedTicketsRepository.findAllByOrderBytravelStartDateAsc();
	}

	@Override
	public List<RequestedTickets> FilterByPriorityAllTickets(Integer priority) {

		return this.requestedTicketsRepository.findAllByPriority(priority);
	}

	@Override
	public List<RequestedTickets> FilterByProjectNameAllTickets(String projectName) {
		return this.requestedTicketsRepository.findAllByProjectName(projectName);
	}

	@Override
	public List<RequestedTickets> FilterByPersonAllTickets(String firstName) {
		Optional<Employee> person = this.employeeRepository.findAllByFirstName(firstName);
		if (person.isPresent()) {
			Employee personData = person.get();
			long id = personData.getEmpId();
			return this.requestedTicketsRepository.findAllByBu(id);
		} else {
			throw new ResourceNotFoundException("Resources not found");
		}
	}

	@Override
	public List<RequestedTickets> FilterByTravelCityAllTickets(String toTravelCity) {
		return this.requestedTicketsRepository.findAllByToTravelCity(toTravelCity);
	}

	@Override
	public boolean updateCommentOfTicket(long ticketId, RequestedTickets requestedTickets) {
		Optional<RequestedTickets> update = this.requestedTicketsRepository.findById(ticketId);
		if (update.isPresent()) {
			RequestedTickets updatedata = update.get();
			updatedata.setComments(requestedTickets.getComments());
			this.requestedTicketsRepository.save(updatedata);
			return true;
		} else {
			return false;
		}

	}

}
