package com.atcportal.partandprojectmanager.models;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// For Date formatting https://www.javatpoint.com/java-date-to-string

@Entity
@Table(name = "project_master",uniqueConstraints = { @UniqueConstraint(columnNames = "PROJECTID") })
public class ProjectMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECTID")
	private int projectId;


	@Column(name = "PROJECTNAME")
	private String projectName;


	@Column(name = "QUOTENUMBER")
	private String quoteNumber;


	@Column(name = "REVISION")
	private int revisionNo;


	@Column(name = "SITENAME")
	private String siteName;


	@Column(name = "POSTCODE")
	private String postCode;

	@Column(name = "CITYNAME")
	private String cityName;

	@Column(name = "ENGINERID")
	private int enginerId;


	@Column(name = "ENGINERNAME")
	private String enginerName;


	@Column(name = "QUOTETYPE")
	private String quoteType;


	@Column(name = "MARKET")
	private String maket;


	@Column(name = "COMPETITION")
	private String competion;


	@Column(name = "CONTRACTTYPE")
	private String contractType;


	@Column(name = "CUSTOMERTYPE")
	private String customerType;

	//@UpdateTimestamp
	@Column(name = "ORDERDATE")
	private Date orderDate;


	@Column(name = "POSSIBLITYCHANCE")
	private String possiblityChance;


	@Column(name = "PROJECTSTATUS")
	private String projectStatus;

	@Column(name = "ESTPRICE")
	private double projectEstPrice;


	//------ All Getter and Setter -----------
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getQuoteNumber() {
		return quoteNumber;
	}

	public void setQuoteNumber(String quoteNumber) {
		this.quoteNumber = quoteNumber;
	}

	public int getRevisionNo() {
		return revisionNo;
	}

	public void setRevisionNo(int revisionNo) {
		this.revisionNo = revisionNo;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCityName() { return cityName; 	}

	public void setCityName(String cityName) { this.cityName = cityName; }

	public String getEnginerName() {
		return enginerName;
	}

	public void setEnginerName(String enginerName) {
		this.enginerName = enginerName;
	}

	public int getEnginerId() { 	return enginerId; }

	public void setEnginerId(int enginerId) { this.enginerId = enginerId; }

	public String getQuoteType() {
		return quoteType;
	}

	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}

	public String getMaket() {
		return maket;
	}

	public void setMaket(String maket) {
		this.maket = maket;
	}

	public String getCompetion() {
		return competion;
	}

	public void setCompetion(String competition) {
		this.competion = competion;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Date getOrderDate() {return new Date(new SimpleDateFormat("dd MMM yyyy").format(orderDate));}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPossiblityChance() {
		return possiblityChance;
	}

	public void setPossiblityChance(String possiblityChance) {
		this.possiblityChance = possiblityChance;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public double getProjectEstPrice() {
		return projectEstPrice;
	}

	public void setProjectEstPrice(double projectEstPrice) {
		this.projectEstPrice = projectEstPrice;
	}


}