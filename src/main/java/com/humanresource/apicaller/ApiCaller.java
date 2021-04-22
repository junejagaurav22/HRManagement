package com.humanresource.apicaller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.humanresource.api.uri.Variables;
import com.humanresource.entities.Employee;

@Component
public class ApiCaller {

 

    public List<Employee> getEmployees() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("check");

        Employee[] users = null;
        try {
            users = restTemplate.getForObject(Variables.GET_All_EMP, Employee[].class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        List<Employee> list=users!=null?Arrays.asList(users):new ArrayList<>();
        return list;
    }
   
    public void addEmployee(Employee employee) {
        RestTemplate restTemplate=new RestTemplate();
        System.out.println("nyi entry");
        String resultString = Variables.ADD_EMP;
        try {
            restTemplate.postForObject(resultString, employee , Employee.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEmployee(int id) {
        String varString=(Variables.DEL_EMP+"/"+id);
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete(varString);
    }
    
    public void downloadList(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String file = fetchAllEmployeesFile();
        InputStream stream = new ByteArrayInputStream(file.getBytes(StandardCharsets.UTF_8));
        PrintWriter out = response.getWriter();
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=employeesInfo.txt");
        int i;
        while ((i = stream.read()) != -1) {
        out.write(i);
        }
        stream.close();
        out.close();
    }
    
    public String fetchAllEmployeesFile() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(Variables.GET_All_EMP, String.class);
    }

}
