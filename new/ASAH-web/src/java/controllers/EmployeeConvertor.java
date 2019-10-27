/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Guan
 */


import hms.entities.Employee;
 import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;

 import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
 import javax.faces.component.UIComponent;
 import javax.faces.context.FacesContext;
 import javax.faces.convert.Converter;
 import javax.faces.convert.ConverterException;
 import javax.faces.convert.FacesConverter;
import mbeans.EmployeeManagerBean;

 @FacesConverter(forClass = hms.entities.Employee.class,value="convertEmployee")
 
 public class EmployeeConvertor implements Converter{
    @ManagedProperty(value="#{employeeManagerBean}") 
    EmployeeManagerBean employeeManagerBean;
    
    public List<hms.entities.Employee> employeeDb; //= propertyManagedBean.getAllContactPeople();

    public EmployeeConvertor() 
    {
        try
        {
            //instantiate propertyManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            employeeManagerBean = (EmployeeManagerBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "employeeManagerBean");


        
        }
        catch(Exception ex)
        {
            String s="";
            String y=ex.getMessage();
        }
    }
                       
    //this method is for converting the submittedValue (here it means the contact person id) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the id.
    public hms.entities.Employee getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (hms.entities.Employee e : employeeDb) {
                    int rr=e.getRid();
                    if (rr== number) {
                        return e;
                    }
                }

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid contact person"));
            }
        }

        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            String s=String.valueOf(((hms.entities.Employee) value).getRid());
            return s;
        }
    }
}
