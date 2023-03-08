package com.time.greenTime.advice;

public class MeetingDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MeetingDoesNotExistException(Integer customerId){
	    super(customerId + " does not exist.");
	  }
}
