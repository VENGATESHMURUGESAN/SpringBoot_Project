package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity


@Data
@NoArgsConstructor
//@Table(name="Venga")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
	private Long departmentId;
    
    @NotBlank(message="Please add department")
	private String departmentName;
	private String departmentAddress; 
	private String departmentCode;
	
	
	
	
} 
