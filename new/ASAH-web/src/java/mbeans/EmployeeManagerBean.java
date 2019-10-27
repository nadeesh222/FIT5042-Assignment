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
import javax.faces.bean.*;
import hms.entities.Employee;
import hms.interfaces.EmployeeInt;
import javax.faces.bean.ManagedBean;

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
      private Employee employee;
    public EmployeeManagerBean() {
        
        employees=new ArrayList<Employee>();
//        employees.add(new Employee(1, "ss", "sddd", 1, 212 , "ss  ", "ee", "rrr", 0));
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

  

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public ArrayList<Employee> getAllEmployees() {
        try {
              
              List<Employee> l =  employeeInt.getAllEmployees();
              
          

                employees = new ArrayList<Employee>();

                if (l != null) {
                    for (int i = 0; i < l.size(); i++) {
                        //Employee ee=(Employee)l.get(i);
                        employees.add(l.get(i));
                    }

                    return employees;
                } else {
                    return null;
                }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}
