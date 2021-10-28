package com.moz.policemanager.ui.response;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseException {
	
	private Integer status;
	private String message;
	private LocalDateTime dateTime;
	private List<Field> fields;
	
	public static class Field{
		
		private String filed;
		private String message;
		
		public Field(String filed, String message) {
			super();
			this.filed = filed;
			this.message = message;
		}

		public String getFiled() {
			return filed;
		}
		public void setFiled(String filed) {
			this.filed = filed;
		}

		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
}
