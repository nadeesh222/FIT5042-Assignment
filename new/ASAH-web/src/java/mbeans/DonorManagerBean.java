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
import hms.entities.Donor;
import hms.interfaces.DonorInt;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Nadeesh
 */
//@Named(value="donorManagerBean")
@ManagedBean(name = "donorManagerBean")
@SessionScoped
public class DonorManagerBean implements Serializable {

    @EJB
    DonorInt donorInt;

    private ArrayList<Donor> donors;
    private int donId;
    private Donor donor;
    
    public int getDonId() {
        return donId;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public void setDonId(int donId) {
        this.donId = donId;
    }
    public DonorManagerBean() {

    }

    public void addDonor(String name, String address, String contactno) {

        try {

            Donor d = new Donor();
            d.setStatus(1);
            d.setName(name);
            d.setAddress(address);
            d.setContactno(contactno);
            donorInt.addDonor(d);
            setDonors(null);//to reload all donors fromm database
            
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Donor inserted successfully", null);
            
            
        } catch (Exception ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    public ArrayList<Donor> getDonors() {
        return donors;
    }

    public void setDonors(ArrayList<Donor> donors) {
        this.donors = donors;
    }
public Donor getDonorByDonId(int donid){
   return  donorInt.getDonorByDonId(donid);

}
    public ArrayList<Donor> getAllDonors() {
        try {

            if (donors == null) {
                List<Donor> l = donorInt.getAllDonorsAsc();

                donors = new ArrayList<Donor>();

                if (l != null) {
                    for (int i = 0; i < l.size(); i++) {
                        donors.add(l.get(i));
                    }

                    return donors;
                } else {
                    return null;
                }

            }
            return donors;

        } catch (Exception ex) {
            Logger.getLogger(DonorManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void cancelAction(Donor d) {
        d.setEditable(false);

        d.setUpdateButtonOn(false);
        d.setEditButtonOn(true);

    }

    public void updateAction(Donor d) {
        d.setEditable(false);
        d.setUpdateButtonOn(false);
        d.setEditButtonOn(true);
        donorInt.updateDonor(d);//Updating the donor
    }

    public void deleteAction(Donor d) {
        if (d != null) {
            d.setEditable(false);
            d.setUpdateButtonOn(false);
            d.setEditButtonOn(true);
            d.setStatus(0);
            donorInt.updateDonor(d);//Updating the donor
            setDonors(null);
        }
    }

    public void editAction(Donor d) {
        if (d != null) {
            d.setEditable(true);
            d.setUpdateButtonOn(true);
            d.setEditButtonOn(false);
        }
    }

}
