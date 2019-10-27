/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.interfaces;

import hms.entities.Donor;
import java.util.List;
import hms.entities.Employee;
import javax.ejb.Remote;

/**
 *
 * @author Nadeesh
 */
@Remote
public interface DonorInt {

    void addDonor(Donor donor);
    void updateDonor(Donor donor);
    int diactivateDonor(int donId);
    List<Donor> getAllDonorsDesc();
     List<Donor> getAllDonorsAsc();
     int findMaxDonorId();
      Donor getDonorByDonId(int donId);
}
