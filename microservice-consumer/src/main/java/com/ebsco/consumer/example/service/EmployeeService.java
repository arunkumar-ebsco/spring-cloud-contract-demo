package com.ebsco.consumer.example.service;

/**
 * Created by aganapathy on 12/12/17.
 */
import com.ebsco.consumer.example.dao.EmployeeDao;
import com.ebsco.consumer.example.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeService {

    @Autowired EmployeeDao employeeDao;

    public Response getEmployeeDetails(){
        Response response = employeeDao.getEmployeeById();
        return response;
    }
}
