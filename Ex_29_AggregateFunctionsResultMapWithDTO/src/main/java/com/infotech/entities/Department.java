package com.infotech.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "department_table")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private long id;

	@Column(name = "dept_name", nullable = false, unique = true, length = 100)
	private String name;

	@Column(name = "dept_location", nullable = false, length = 100)
	private String location;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Employee> employees = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}