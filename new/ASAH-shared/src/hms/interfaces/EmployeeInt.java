/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.interfaces;

import java.util.List;
import hms.entities.Employee;
import javax.ejb.Remote;

/**
 *
 * @author Nadeesh
 */
@Remote
public interface EmployeeInt {

    int addEmployee(Employee employee);

    int updateEmployee(int empid, Employee employee);

    int diactivateEmployee(int empid);

    List<Employee> getAllEmployees();
}
