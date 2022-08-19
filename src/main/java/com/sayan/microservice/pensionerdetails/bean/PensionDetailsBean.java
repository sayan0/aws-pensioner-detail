package com.sayan.microservice.pensionerdetails.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PensionDetails")
public class PensionDetailsBean {

	@Id
	@Column(name = "aadharno" )
	private String aadharno;
	
	@Column(name = "allowances" )
	private int allowances;
	
	@Column(name = "bankdetails" )
	private String bankdetails;
	
	@Column(name = "dob" )
	private Date dob;
	
	@Column(name = "name" )
	private String name;
	
	@Column(name = "pan" )
	private String pan;
	
	@Column(name = "salary" )
	private int salary;
	
	@Column(name = "type" )
	private String type;
	
	
	@Override
	public String toString() {
		return "PensionDetailsBean [name=" + name + ", dob=" + dob + ", pan=" + pan + ", salary=" + salary
				+ ", allowances=" + allowances + ", type=" + type + ", bankdetails=" + bankdetails + "]";
	}
	
	public PensionDetailsBean() {
		
	}
	
	public PensionDetailsBean(String pen[]) throws ParseException {
		super();
		this.name = pen[0];
		this.dob = new SimpleDateFormat("dd-MM-yyyy").parse(pen[1]);
		this.pan = pen[2];
		this.salary = Integer.parseInt(pen[3]);
		this.allowances = Integer.parseInt(pen[4]);
		this.type = pen[5];
		this.bankdetails = pen[6];
		this.aadharno = pen[7];
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAllowances() {
		return allowances;
	}
	public void setAllowances(int allowances) {
		this.allowances = allowances;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBankdetails() {
		return bankdetails;
	}
	public void setBankdetails(String bankdetails) {
		this.bankdetails = bankdetails;
	}
	public String getAadharno() {
		return aadharno;
	}
	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}
	
}
