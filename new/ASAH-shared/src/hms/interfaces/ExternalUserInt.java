/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.interfaces;

import hms.entities.Employee;
import hms.entities.ExternalUser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Nadeesh
 */
@Remote
public interface ExternalUserInt {

    void addExternalUser(ExternalUser donor);

    void updateExternalUser(ExternalUser donor);

    int diactivateExternalUser(int donId);

    List<ExternalUser> getAllExternalUsersDesc();

    List<ExternalUser> getAllExternalUsersAsc();

    int findMaxExternalUserId();

    ExternalUser getExternalUserByDonId(int donId);
}
