package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Department;
import com.example.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@Validated
public class DepartmentController {

	/* DepartmentRepository departmentRepository; */

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);

	// @RequestMapping(path="/departments",method=RequestMethod.POST)
	@PostMapping(path = "/departments")
	public Department saveDepartment( @Valid @RequestBody Department department) {

		/*
		 * departmentRepository.save(department); return department;
		 */
		LOGGER.info("Inside SaveDepartment Controller");

		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Inside fetchDepartmentList Controller");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{Id}") 
	public Department fetchDepartmentById(@PathVariable("Id") Long DepartmentId)
	{
		return departmentService.fetchDepartment(DepartmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long DepartmentId) {
		departmentService.deleteDepartmentById(DepartmentId);
		return "Department has been deleted";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id")Long departmentId, @RequestBody Department department) {
		
		return departmentService.updateDepartment(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}

}
