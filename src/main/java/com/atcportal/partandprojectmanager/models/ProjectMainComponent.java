package com.atcportal.partandprojectmanager.models;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_main_component",uniqueConstraints = { @UniqueConstraint(columnNames = "PROJCOMPONENTID") })
public class ProjectMainComponent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJCOMPONENTID")
	private int projectMainComponentId;


	@Column(name = "PROJECTID")
	private int projectId;


	@Column(name = "COMPONENT_NAME")
	private String componentName;


	@Column(name = "SUB_COMPONENT_NAME")
	private String subComponentName;



	@Column(name = "ADDED_DATE")
	private Date addedDate;



	@Column(name = "ADDED_BY_LOGIN_NAME")
	private String addedByLoginName;



	//-------- All Getter and Setter -------------
	public int getProjectMainComponentId() {
		return projectMainComponentId;
	}

	public void setProjectMainComponentId(int projectMainComponentId) {
		this.projectMainComponentId = projectMainComponentId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getSubComponentName() {
		return subComponentName;
	}

	public void setSubComponentName(String subComponentName) {
		this.subComponentName = subComponentName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getAddedByLoginName() {
		return addedByLoginName;
	}

	public void setAddedByLoginName(String addedByLoginName) {
		this.addedByLoginName = addedByLoginName;
	}
}