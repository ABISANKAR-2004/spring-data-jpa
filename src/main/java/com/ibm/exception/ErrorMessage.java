package com.ibm.exception;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ErrorMessage {
	private String timeStamp;
	private Integer status;
	private String message;
	private String path;
	
	public ErrorMessage(Integer status, String message,String path){
		this.timeStamp= LocalTime.now().toString();
		this.status= status;
		this.message=message;
		this.path=path;
	}
}
