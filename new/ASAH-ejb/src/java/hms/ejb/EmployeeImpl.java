/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import hms.entities.Employee;
import hms.interfaces.EmployeeInt;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nadeesh
 */
@Stateless

public class EmployeeImpl implements EmployeeInt {

    @PersistenceContext(unitName = "HMS-ejbPU")
    private EntityManager entityManager;

    @Override
    public int addEmployee(Employee employee) {
//        List<Employee> emp = entityManager.createNamedQuery("Employee.findAll").getResultList();
//        if (emp != null && emp.size() > 0) {
//            employee.setEmpid(emp.get(0).getEmpid() + 1);
//        } else {
//            employee.setEmpid(1);
//        }
//        entityManager.persist(employee);
        return 1;
    }

    @Override
    public int updateEmployee(int empid, Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int diactivateEmployee(int empid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> empList = null;
        try {

            //empList 
             empList = entityManager.createNamedQuery("Employee.findAll").getResultList();

        } catch (Exception ex) {
            String y = "";
        }
        return empList;

    }

}
