package com.exception;

public class TrainerNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public TrainerNotAvailableException(String message) {
        super(message);
    }
}