package com.in28minutes.springboot.web.springbootfirstwebapplication.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	
	@Size(min=5, message="Enter at least 5 Characters..")
	private String description;
	
	private Long id;
	
	private String user;
	
	private Date targetDate;
	
	private Boolean done;
	
	/**
	 * @param description
	 * @param id
	 * @param user
	 * @param targetDate
	 * @param done
	 */
	public Todo(String description, Long id, String user, Date targetDate, Boolean done) {
		super();
		this.description = description;
		this.id = id;
		this.user = user;
		this.targetDate = targetDate;
		this.done = done;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the targetDate
	 */
	public Date getTargetDate() {
		return targetDate;
	}

	/**
	 * @param targetDate the targetDate to set
	 */
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * @return the done
	 */
	public Boolean getDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(Boolean done) {
		this.done = done;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Todo [description=" + description + ", id=" + id + ", user=" + user + ", targetDate=" + targetDate
				+ ", done=" + done + "]";
	}

}
