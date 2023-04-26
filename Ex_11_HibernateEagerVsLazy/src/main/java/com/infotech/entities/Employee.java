package com.infotech.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.infotech.model.Address;

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "employee_name", length = 100, nullable = false)
	private String employeeName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "date_of_joining")
	private Date doj;
	
//	@ElementCollection
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="address_table",joinColumns=@JoinColumn(name="employee_id"))
	@GenericGenerator(name="sequence_gen",strategy="sequence")
	@CollectionId(columns= {@Column(name="address_id")},generator="sequence_gen",type=@Type(type="int"))
	private Collection<Address> addressList=new HashSet<>();

	@Column(name = "salary")
	private Double salary;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	

	public Collection<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", doj="
				+ doj + ", salary=" + salary + "]";
	}

	
}
