package com.model;

public class Trainer {

	private int trainerId;
	private String trainerName;
	private String specialization;
	private String contact;
	private String email;
	private boolean isActive;
	

	public Trainer() {

	}

	public Trainer(String trainerName, String specialization, String contact, String email, boolean isActive) {

		this.trainerName = trainerName;
		this.specialization = specialization;
		this.contact = contact;
		this.email = email;
		this.isActive = isActive;
		
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
	    return isActive;
	}

	public void setIsActive(boolean isActive) {
	    this.isActive = isActive;
	}

	
	

	
}