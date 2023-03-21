package com.example.assigntask.modal;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Task")
public class OnlyProgress {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="taskId")
	private long taskId;

	@NotNull
	@NotEmpty(message=" Taskname should not be empty")
	@Column(name="taskName")
	private String taskName;

	@NotNull
	@NotEmpty(message="  description should not be empty")
	@Column(name="description")
	private String description;

	
	@Column(name="dueDate")
	private LocalDate dueDate;

	@NotNull
	@NotEmpty(message="  Taskstatus should not be empty")
	@Column(name="taskSStatus")
	private String taskStatus;

	@Column(name="taskProgress")
	private String taskProgress;
	
	@NotEmpty(message=" Employeeemailid should not be empty")
	@Email
	@Column(name="email_id")
	private String emailId;
	
	@NotEmpty(message=" Manageremailid should not be empty")
	@Email
	@Column(name="memail_id")
	private String memailId;

	public String getTaskProgress() {
		return taskProgress;
	}

	public void setTaskProgress(String taskProgress) {
		this.taskProgress = taskProgress;
	}

		
		
		

}
