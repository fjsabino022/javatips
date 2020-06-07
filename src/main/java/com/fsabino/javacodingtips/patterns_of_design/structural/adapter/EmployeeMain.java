package com.fsabino.javacodingtips.patterns_of_design.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args){

        // create list employee interface
        List<Employee> listEmployee = new ArrayList<Employee>();

        // create an object EmployeeDB
        Employee e = new EmployeeDB("1", "FRANCO", "SABINO", "fjs_022@hotmail.com");

        // add an objecto employeeDB
        listEmployee.add(e);

        // create an object EmployeeLDAP
        EmployeeLDAP employeeLDAP = new EmployeeLDAP("2", "Ezequiel", "Tsumaj", "xxxx@xxx.com");
        //listEmployee.add(employeeLDAP);
        // EmployeeLDAP is a code legacy and I can't add in listEmployee

        Employee eLDAP = new EmployeeLDAPAdapter(employeeLDAP);

        // now I can add eLDAP object and I don't modify employeeLDAP because It's legacy code.
        listEmployee.add(eLDAP);

        listEmployee.forEach(System.out::println);
    }
}
