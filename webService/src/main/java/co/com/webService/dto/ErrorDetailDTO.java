package co.com.webService.dto;

import java.util.Date;

public class ErrorDetailDTO {
	private Date time;
	private String message;
	private String details;
	private int status;
	
	public ErrorDetailDTO(Date time, String message, String details, int status) {
		super();
		this.time = time;
		this.message = message;
		this.details = details;
		this.status = status;
	}

	public Date getTime() {
		return time;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public int getStatus() {
		return status;
	}
	
}
