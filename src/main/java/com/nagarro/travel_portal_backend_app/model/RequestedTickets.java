package com.nagarro.travel_portal_backend_app.model;


/**
 * This is Requested Tickets Model
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */


import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@SequenceGenerator(name="sequence", initialValue=10001, allocationSize=100)
@Table(name="requested_tickets")
public class RequestedTickets implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="sequence")
	@Column(name="ticketId")
	private long ticketId;
	
	@Column(name="requestType")
	@NotNull(message = "The requestType must not be null")
	@Size(max = 50)
	private String requestType;
	
	@Column(name="priority")
	@NotNull(message = "The priority must not be null")
	private Integer priority;
	
	@Column(name="toTravelCity")
	@NotNull(message = "The toTravelcity must not be null")
	@Size(max = 50)
	private String toTravelCity;
	
	@Column(name="fromTravelCity")
	@NotNull(message = "The fromTravelcity must not be null")
	@Size(max = 50)
	private String fromTravelCity;
	
	//'YYYY-MM-DD'
	@Column(name="travelStartDate")
	@NotNull(message = "The travelstartdate must not be null")
	@Size(max = 50)
	private String travelStartDate;
	
	@Column(name="travelEndDate")
	@NotNull(message = "The travelenddate must not be null")
	@Size(max = 50)
	private String travelEndDate;
	
	@Column(name="passportNumber")
	@NotNull(message = "The passportnumber must not be null")
	@Size(max = 25)
	private String passportNumber;
	
	@Column(name="projectName")
	@Size(max = 100)
	@NotNull(message = "The projectname must not be null")
	private String projectName;
	
	@Column(name="expenseBorneBy")
	@NotNull(message = "The expences must not be null")
	@Size(max = 50)
	private String expenseBorneBy;
	
	@Column(name="travelApproverName")
	@Size(max = 50)
	private String travelApproverName;
	
	@Column(name="durationOfTravel")
	@Size(max = 50)
	private String durationOfTravel;
	
	@Column(name="upperBoundAmount")
	@Size(max = 50)
	private String upperBoundAmount;
	
	@Column(name="additionalComments")
	@NotNull(message = "The additional comments must not be null")
	@Size(max = 1000)
	private String additionalComments;
	
	
	@Column(name="empId")
	@NotNull(message = "The emp id must not be null")
	private long empId;
	
	@Column(name="status",nullable=false)
	private String status = "SUBMITTED";
	
	@CreationTimestamp
    @Column(name = "createdAt", updatable = false)
    private LocalDate createdAt;

	@UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDate updatedAt;
    
    @Column(name="files")
	private Blob files;
	
	@Column(name="comments")
	@Size(max = 1000)
	private String comments = "No Comments";

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getToTravelCity() {
		return toTravelCity;
	}

	public void setToTravelCity(String toTravelCity) {
		this.toTravelCity = toTravelCity;
	}

	public String getFromTravelCity() {
		return fromTravelCity;
	}

	public void setFromTravelCity(String fromTravelCity) {
		this.fromTravelCity = fromTravelCity;
	}

	public String getTravelStartDate() {
		return travelStartDate;
	}

	public void setTravelStartDate(String travelStartDate) {
		this.travelStartDate = travelStartDate;
	}

	public String getTravelEndDate() {
		return travelEndDate;
	}

	public void setTravelEndDate(String travelEndDate) {
		this.travelEndDate = travelEndDate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getExpenseBorneBy() {
		return expenseBorneBy;
	}

	public void setExpenseBorneBy(String expenseBorneBy) {
		this.expenseBorneBy = expenseBorneBy;
	}

	public String getTravelApproverName() {
		return travelApproverName;
	}

	public void setTravelApproverName(String travelApproverName) {
		this.travelApproverName = travelApproverName;
	}

	public String getDurationOfTravel() {
		return durationOfTravel;
	}

	public void setDurationOfTravel(String durationOfTravel) {
		this.durationOfTravel = durationOfTravel;
	}

	public String getUpperBoundAmount() {
		return upperBoundAmount;
	}

	public void setUpperBoundAmount(String upperBoundAmount) {
		this.upperBoundAmount = upperBoundAmount;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Blob getFiles() {
		return files;
	}

	public void setFiles(Blob files) {
		this.files = files;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "emp_id", nullable = false, updatable=false, insertable= false)
//    @JsonIgnore
//    private Employee employees;
	
	
	


	


	

//	@OneToOne(mappedBy = "req_tickets", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Tickets tickets;
	



//	public Employee getEmployees() {
//		return employees;
//	}
//
//
//
//	public void setEmployees(Employee employees) {
//		this.employees = employees;
//	}
//
//
//
//	public Tickets getTickets() {
//		return tickets;
//	}
//
//
//
//	public void setTickets(Tickets tickets) {
//		this.tickets = tickets;
//	}




	
	
	
		

}
