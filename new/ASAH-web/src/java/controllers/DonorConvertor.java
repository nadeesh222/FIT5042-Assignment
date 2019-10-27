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
import mbeans.DonorManagerBean;

 @FacesConverter(forClass = hms.entities.Donor.class,value="convertDonor")
 
 public class DonorConvertor implements Converter{
    @ManagedProperty(value="#{donorManagerBean}") 
    DonorManagerBean donorManagerBean;
    
    public List<hms.entities.Donor> donorDb; //= propertyManagedBean.getAllContactPeople();

    public DonorConvertor() 
    {
        try
        {
            //instantiate propertyManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            donorManagerBean = (DonorManagerBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "donorManagerBean");

            donorDb = donorManagerBean.getAllDonors();
        }
        catch(Exception ex)
        {
            
        }
    }
                       
    //this method is for converting the submittedValue (here it means the contact person id) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the id.
    public hms.entities.Donor getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (hms.entities.Donor c : donorDb) {
                    if (c.getDonid()== number) {
                        return c;
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
            return String.valueOf(((hms.entities.Donor) value).getDonid());
        }
    }
}
