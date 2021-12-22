package com.atcportal.partandprojectmanager.models;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "part_master",uniqueConstraints = { @UniqueConstraint(columnNames = "PARTID") })
public class PartsMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARTID")
	private int partsId;


	@Column(name = "PARTREF")
	private String partRefrenceNo;


	@Column(name = "PARTSHORTDESCRIPTION")
	private String partShortDescription;


	@Column(name = "PARTLONGDESCRIPTION")
	private String partLongDescription;


	@Column(name = "PARTPRICE")
	private Double partPrice;


	@UpdateTimestamp
	@Column(name = "ADDEDDATE")
	private Date addedDate;


	@Column(name = "USERID")
	private String userId;


	public int getPartsId() { 	return partsId; }

	public void setPartsId(int partsId) { 	this.partsId = partsId; }

	public String getPartRefrenceNo() { return partRefrenceNo; 	}

	public void setPartRefrenceNo(String partRefrenceNo) { 	this.partRefrenceNo = partRefrenceNo; }

	public String getPartShortDescription() { return partShortDescription; 	}

	public void setPartShortDescription(String partShortDescription) { 	this.partShortDescription = partShortDescription; }

	public String getPartLongDescription() { return partLongDescription; }

	public void setPartLongDescription(String partLongDescription) { this.partLongDescription = partLongDescription; }

	public Double getPartPrice() { 	return partPrice; }

	public void setPartPrice(Double partPrice) { this.partPrice = partPrice; }

	public String getAddedDate() {
		return new SimpleDateFormat("dd MMM yyyy").format(addedDate);
	}

	public void setAddedDate(Date addedDate) { 	this.addedDate = addedDate; }

	public String getUserId() { return userId; }

	public void setUserId(String userId) { this.userId = userId; }

}