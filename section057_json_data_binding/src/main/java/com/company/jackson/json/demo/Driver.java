package com.company.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;


public class Driver {
    public static void main(String[] args) {
        try{
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO
            Student theStudent = mapper.readValue(ResourceUtils.getFile("classpath:sample-full.json"), Student.class);

            // print details
            System.out.println(theStudent.getId());
            System.out.println(theStudent.getFirstName());
            System.out.println(theStudent.getLastName());
            System.out.println(theStudent.isActive());

            // print nested data
            Address theAddress = theStudent.getAddress();
            System.out.println("Street: " + theAddress.getStreet());
            System.out.println("City: " + theAddress.getCity());


            // print array
            String[] theLanguages = theStudent.getLanguages();
            for(String lang : theLanguages){
                System.out.println(lang);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
