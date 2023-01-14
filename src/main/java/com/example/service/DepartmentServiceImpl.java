package com.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {

		return departmentRepository.save(department);

	}

	public List<Department> fetchDepartmentList() {

		return departmentRepository.findAll();
	}

	public Department fetchDepartment(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	public void deleteDepartmentById(Long DepartmentById) {

		departmentRepository.deleteById(DepartmentById);
	}

	public Department updateDepartment(Long departmentId, Department department) {

		Department depDB = departmentRepository.findById(departmentId).get();

		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		if (Objects.nonNull(department.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		} 

		return departmentRepository.save(depDB);
	}

	public Department fetchDepartmentByName(String departmentName) {

		// return departmentRepository.findByDepartmentName(departmentName);
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
