package com.atcportal.PartAndProjectManager.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_master",uniqueConstraints = { @UniqueConstraint(columnNames = "PROJECTID") })
public class ProjectMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECTID")
	private long projectId;


	@Column(name = "NAME")
	private String projectName;


	@Column(name = "QUOTENUMBER")
	private String quoteNumber;


	@Column(name = "REVISION")
	private int revisionNo;


	@Column(name = "SITENAME")
	private String siteName;


	@Column(name = "POSTCODE")
	private String postCode;


	@Column(name = "ENGINERNAME")
	private String enginerName;


	@Column(name = "QUOTETYPE")
	private String quoteType;


	@Column(name = "MARKET")
	private String maket;


	@Column(name = "COMPETITION")
	private String competition;


	@Column(name = "CONTRACTTYPE")
	private String contractType;


	@Column(name = "CUSTOMERTYPE")
	private String cusgtomerType;


	@Column(name = "ORDERDATE")
	private Date orderDate;


	@Column(name = "POSSIBLITYCHANCE")
	private String possiblityChance;



	//------ All Getter and Setter -----------

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getQuoteNumber() {
		return quoteNumber;
	}

	public void setQuoteNumber(String quoteNumber) { this.quoteNumber = quoteNumber; }

	public int getRevisionNo() {
		return revisionNo;
	}

	public void setRevisionNo(int revisionNo) {
		this.revisionNo = revisionNo;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) { 	this.siteName = siteName; 	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {  this.postCode = postCode; }

	public String getEnginerName() {
		return enginerName;
	}

	public void setEnginerName(String enginerName) {
		this.enginerName = enginerName;
	}

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

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getCusgtomerType() {
		return cusgtomerType;
	}

	public void setCusgtomerType(String cusgtomerType) { this.cusgtomerType = cusgtomerType; }

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPossiblityChance() {
		return possiblityChance;
	}

	public void setPossiblityChance(String possiblityChance) {
		this.possiblityChance = possiblityChance;
	}

}