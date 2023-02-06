package com.time.greenTime.advice;

import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, Object> getValidationMessage(ConstraintViolationException e, HttpServletRequest request) {

		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("Status", HttpStatus.BAD_REQUEST.toString());
		result.put("Message", writeAsString(e.toString()));
		return result;
	}

	private String writeAsString(String str) {

		if (str.contains("messageTemplate")) {
			return str.substring(str.indexOf("messageTemplate='") + 16, str.indexOf("'}"));
		} else {
			return str;
		}

	}
}
