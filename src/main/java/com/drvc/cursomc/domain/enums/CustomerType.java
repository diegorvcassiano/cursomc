package com.drvc.cursomc.domain.enums;

public enum CustomerType {

	PERSON(1, "Person"), 				// Pessoa Fisica in Brazil
	ORGANIZATION(2, "Organization"); 	// Pessoa Juridica in Brazil
	
	private int code;
	private String description;
	
	private CustomerType(int code, String description) {
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
	
	public static CustomerType toEnum(Integer code) {
		if (code == null) {
			return null;			
		} 
		
		for (CustomerType x: CustomerType.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id for CustomerType " + code);
	}
}
