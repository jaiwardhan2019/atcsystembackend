package com.atcportal.projectmanager.service;


import com.atcportal.partandprojectmanager.customexception.projectExceptionMaster;
import com.atcportal.partandprojectmanager.daorepository.ProjectDao;
import com.atcportal.partandprojectmanager.models.ProjectMaster;
import com.atcportal.partandprojectmanager.service.ProjectAndPartsService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {


    @Autowired
    ProjectAndPartsService projectService;

    @Test
    public void createProjectQuoteNoForNewProjectStep_01Test() throws projectExceptionMaster {

        System.out.println("Quote No:"+projectService.createProjectQuoteNoForNewProjectStep_01("Jai Wardhan"));


    }



    @Test
    public void convertDatetoString() throws ParseException {
        String dateStr="2021-12-22 15:56:41.0";
        Date dateData=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        System.out.println("Input Date :"+dateStr);
        System.out.println("Output Date :"+new SimpleDateFormat("dd MMM yyyy HH:mm").format(dateData));

    }




    @Test
    public void populateRefNo(){

        String engineerName = "Jai Wardhan";
        int serialno        = 35;
        String nameInitial[] = engineerName.split(" ");
        String quoteNumber = Character.toString(nameInitial[0].charAt(0)) + Character.toString(nameInitial[1].charAt(0));

        Date d=new Date();
        int year=d.getYear()+1900;
        String currentYear = Integer.toString(year);

        quoteNumber = quoteNumber + currentYear.substring(currentYear.length()-2);
        quoteNumber = quoteNumber + padLeftZeros(Integer.toString(serialno),4);
        System.out.println("Quote no:"+quoteNumber);


    }


    private String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);
        return sb.toString();
    }

}
