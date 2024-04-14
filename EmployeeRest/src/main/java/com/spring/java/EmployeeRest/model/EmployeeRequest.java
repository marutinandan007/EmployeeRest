package com.spring.java.EmployeeRest.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@ToString
public class EmployeeRequest {

	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Integer phone;
}
