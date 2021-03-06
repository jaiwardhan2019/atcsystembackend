package com.atcportal;

import com.atcportal.partandprojectmanager.service.ProjectAndPartsService;
import com.atcportal.main.models.UserMaster;
import com.atcportal.main.service.JwtUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaSpringDataApplicationTests {

	@Autowired
	private JwtUserDetailsService userDetailsService;


	@Autowired
	private ProjectAndPartsService objProjService;



	@Test
	public void TestShowMyDetail() {
		UserMaster userDetail = userDetailsService.showMyDetail("mohit");
		System.out.println("User Full Name is :"+userDetail.getUserFullName());
		System.out.println("User Full Address is :"+userDetail.getUserFullAddress());
		System.out.println("User Full Email id :"+userDetail.getUserEmailID());
	}










}
