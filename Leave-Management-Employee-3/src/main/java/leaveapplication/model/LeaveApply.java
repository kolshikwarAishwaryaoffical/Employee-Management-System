package leaveapplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave")
public class LeaveApply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long leaveId;
	
	
	@Column
	private String emailId;
	
	@Column
	private String memailId;
	
	
	
	@Column
	private Date fromDate;
	
	@Column
	private Date toDate;
	
	@Column
	private String leaveReason;
	
	@Column
	private String leaveStatus;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMemailId() {
		return memailId;
	}

	public void setMemailId(String memailId) {
		this.memailId = memailId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	
	

	public long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}

	public LeaveApply() {
		
	}

	public LeaveApply(long leaveId, String emailId, String memailId, Date fromDate, Date toDate, String leaveReason,
			String leaveStatus) {
		super();
		this.leaveId = leaveId;
		this.emailId = emailId;
		this.memailId = memailId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.leaveReason = leaveReason;
		this.leaveStatus = leaveStatus;
	}

	
	
	
	
	

	
	

}
