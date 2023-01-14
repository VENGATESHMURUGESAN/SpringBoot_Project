package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Department;

@Repository

public interface DepartmentRepository extends JpaRepository<Department,Long> {
   
	//we can create querymethod, or native sql or JPQL
	
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	public Department findByDepartmentName(String departmentName);
	
	//@Query(value="",nativeQuery=true) using native method
	public Department findByDepartmentNameIgnoreCase(String departmentName);//QueryMethod
	
}
