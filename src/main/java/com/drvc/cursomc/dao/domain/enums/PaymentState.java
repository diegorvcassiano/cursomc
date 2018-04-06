package com.drvc.cursomc.dao.domain.enums;

public enum PaymentState {
	
	PENDING(1, "Pending"),
	DONE(2, "Done"),
	CANCELLED(3, "Cancelled");
	
	private int code;
	private String description;
	
	private PaymentState(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static PaymentState toEnum(Integer code) {
		if (code == null) {
			return null;			
		} 
		
		for (PaymentState x: PaymentState.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id for PaymentState " + code);
	}
}
