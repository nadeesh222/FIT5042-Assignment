/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
 

import javax.inject.Named;
import hms.entities.Employee;
import hms.interfaces.EmployeeInt;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 * 
 * 
 *
 * @author Nadeesh
 */

//@Named(value="employeeManagerBean")

@ManagedBean(name = "employeeManagerBean")
@SessionScoped
public class EmployeeManagerBean implements Serializable{
    @EJB
    EmployeeInt employeeInt;

      private ArrayList<Employee> employees;

    public EmployeeManagerBean() {
        
        employees=new ArrayList<Employee>();
//        employees.add(new Employee(1, "ss", "sddd", 1, 212 , "ss  ", "ee", "rrr", 0));
    }

  

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public List<Employee> getAllEmployees() {
        try {
            return employeeInt.getAllEmployees();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}
