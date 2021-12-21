package com.atcportal.main.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

public class projectAndPartServiceTest {


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
