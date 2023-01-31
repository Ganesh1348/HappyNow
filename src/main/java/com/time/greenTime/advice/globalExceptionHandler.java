package com.time.greenTime.advice;

import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public Map<String, Object> getGlobalExceptionMessage(Exception e, HttpServletRequest request) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		result.put("Message", e.getLocalizedMessage());
		result.put("TimeStamp", LocalDateTime.now());
		result.put("RequestURL", request.getRequestURL());
		return result;

	}

}
