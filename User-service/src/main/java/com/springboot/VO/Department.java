package com.springboot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	private Long departmentId;
	private String departmentName;
	private String departmentAddrss;
	private String departmentCode;

}
